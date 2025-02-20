import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Parser {
    public Parser() {
    }
    public static Command parse(String prompt) throws KryptoExceptions {
        String[] split = prompt.split(" ");
        String first = split[0];
        return switch (first) {
            case "bye" -> new ExitCommand();
            case "list" -> new ListCommand();
            case "mark" -> new MarkCommand(Integer.parseInt(split[1]) - 1);
            case "unmark" -> new UnmarkCommand(Integer.parseInt(split[1]) - 1);
            case "delete" -> new DeleteCommand(Integer.parseInt(split[1]) - 1);
            case "show" -> new ShowCommand(split[1]);
            case "todo", "event", "deadline" -> createTaskCommand(prompt, split);
            default -> throw new InvalidCommand(first);
        };
    }
    private static Command createTaskCommand(String prompt, String[] split) throws KryptoExceptions {
        String type = split[0];
        String[] parts = prompt.split("/");
        Task newTask;
        switch (type) {
            case "todo":
                if (parts.length > 1 || split.length <= 1) {
                    throw new IncompleteCommand(type);
                }
                newTask = new ToDo(prompt);
                break;
            case "deadline":
                if (parts.length != 2) {
                    throw new IncompleteCommand("deadline");
                }
                try {
                    newTask = new Deadline(prompt, parts[1]);
                } catch (DateTimeParseException e) {
                    throw new KryptoExceptions("Invalid date format! Use dd/MM/yyyy HH:mm (e.g., 2/12/2019 18:00).");
                }
                break;
            case "event":
                if (parts.length != 3) {
                    throw new IncompleteCommand(type);
                }
                try {
                    newTask = new Event(prompt, parts[1], parts[2]);
                } catch (DateTimeParseException e) {
                    throw new KryptoExceptions("Invalid date format! Use dd/MM/yyyy HH:mm (e.g., 2/12/2019 18:00).");
                }
                break;
            default:
                throw new InvalidCommand(type);
        }
        return new AddCommand(newTask);
    }

    public static Task parseStorage(String line) {
        String[] parts = line.split(" \\| ");
        Task task;
        String isMarked = parts[1];
        task = switch (parts[0]) {
            case "T" -> new ToDo("todo " + parts[2]);
            case "D" -> new Deadline("deadline " + parts[2], parts[3]);
            case "E" -> new Event("event " + parts[2], parts[3], parts[4]);
            default -> new Task("");
        };
        if (isMarked.equals("X")) {
            task.markTask(false);
        }
        return task;
    }
}
