import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Krypto {
    private static final String HORIZONTAL_LINE = "-".repeat(100);
    private static final String FILE_PATH = "src/main/data/Krypto.txt";

    private static String printResponse(ArrayList<Task> lst) {
        int len = lst.size();
        return String.format("Got it. I've added this task :  %s\nNow you have %d tasks in the list.", lst.get(len - 1), len);
    }

    public static void printList(ArrayList<Task> lst) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < lst.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, lst.get(i));
        }
        System.out.println(HORIZONTAL_LINE);
    }

    public static void printList(ArrayList<Task> lst, String date) {
        System.out.println(HORIZONTAL_LINE);
        LocalDate queryDate = LocalDate.parse(date);
        boolean found = false;
        System.out.println("Finding tasks on " + queryDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
        for (int i = 0; i < lst.size(); i++) {
           Task t = lst.get(i);
           if(t.onThisDay(date)) {
               System.out.printf("%d. %s\n", i + 1, lst.get(i));
               found = true;
           }
        }
        if(!found) {
            System.out.println("No tasks on this day!");
        }
        System.out.println(HORIZONTAL_LINE);
    }

    public static void printResponseWithLines(String resp) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(resp);
        System.out.println(HORIZONTAL_LINE);
    }

    public static void main(String[] args) {
        ArrayList<Task> arr = loadTasksFromFile();
        printResponseWithLines("Hello, I'm Krypto \nWhat can I do for you?");

        Scanner myObj = new Scanner(System.in);
        while (true) {
            String prompt = myObj.nextLine();
            String[] split = prompt.split(" ");
            String first = split[0];

            if (prompt.equals("bye")) {
                printResponseWithLines("Great talking to you!");
                break;
            } else if (prompt.equals("list")) {
                printList(arr);
                continue;
            } else if (first.equals("mark")) {
                int id = Integer.parseInt(split[1]) - 1;
                arr.get(id).markTask();
                saveTasksToFile(arr);
                continue;
            } else if (first.equals("unmark")) {
                int id = Integer.parseInt(split[1]) - 1;
                arr.get(id).unmarkTask();
                saveTasksToFile(arr);
                continue;
            } else if (first.equals("delete")) {
                int id = Integer.parseInt(split[1]) - 1;
                arr.remove(id);
                saveTasksToFile(arr);
                printResponseWithLines(String.format("Deleted successfully. There are now %d tasks remaining in your list.", arr.size()));
                continue;
            }
            else if(first.equals("show")) {
                printList(arr, split[1]);
                continue;
            }
            try {
                if (checkValid(split)) {
                    Task newTask = getTask(prompt, split);
                    arr.add(newTask);
                    saveTasksToFile(arr);
                    printResponseWithLines(printResponse(arr));
                }
            } catch (KryptoExceptions e) {
                printResponseWithLines(e.toString());
            }
        }
    }

    private static Boolean checkValid(String[] split) throws KryptoExceptions {
        String cmd = split[0];
        Boolean resp = cmd.equals("todo") || cmd.equals("event") || cmd.equals("deadline");
        if (!resp) {
            throw new InvalidCommand(cmd);
        }
        return resp;
    }

    private static Task getTask(String prompt, String[] split) throws KryptoExceptions {
        Task newTask;
        String[] parts = prompt.split("/");
        String type = split[0];

        if (type.equals("todo")) {
            if (parts.length > 1) {
                throw new ToDoException();
            }
            if (split.length <= 1) {
                throw new IncompleteCommand(type);
            }
            newTask = new ToDo(prompt);
        } else if (type.equals("deadline")) {
            if (parts.length != 2) {
                throw new IncompleteCommand("deadline");
            }
            try {
                newTask = new Deadline(prompt, parts[1]);
            } catch (DateTimeParseException e) {
                throw new KryptoExceptions("Invalid date format! Use dd/MM/yyyy HHmm (e.g., 2/12/2019 1800).");
            }
        } else {
            if (parts.length != 3) {
                throw new IncompleteCommand(type);
            }
            newTask = new Event(prompt, parts[1], parts[2]);
        }
        return newTask;
    }

    private static ArrayList<Task> loadTasksFromFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()){
            System.out.println("File not found! Expected at: " + file.getAbsolutePath());
            return tasks;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" \\| ");
                Task task;
                String isMarked = parts[1];
                switch (parts[0]) {
                    case "T":
                        task = new ToDo("todo "+ parts[2]);
                        break;
                    case "D":
                        task = new Deadline("deadline " + parts[2], parts[3]);
                        break;
                    case "E":
                        task = new Event("event " + parts[2], parts[3], parts[4]);
                        break;
                    default:
                        continue;
                }
                if (isMarked.equals("X")) {
                    task.markTask(false);
                }
                tasks.add(task);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error loading tasks: File not found.");
        }
        return tasks;
    }

    private static void saveTasksToFile(ArrayList<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
    }
}