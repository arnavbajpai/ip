package Krypto.Task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task with a deadline.
 */
public class Deadline extends Task {

    protected LocalDateTime by;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy ha");

    /**
     * Constructs a Deadline object with the specified description and deadline time.
     *
     * @param description Description of the task.
     * @param by Deadline of the task in the format "yyyy-MM-dd HH:mm".
     * @throws DateTimeParseException If the provided deadline cannot be parsed.
     */
    public Deadline(String description, String by) throws DateTimeParseException {
        super(extractContent(description.split("/")[0].split(" ")));
        this.by = LocalDateTime.parse(by, INPUT_FORMAT);
    }

    /**
     * Checks if the task is due on the specified date.
     *
     * @param date The date to check, in the format "yyyy-MM-dd".
     * @return True if the task is due on the specified date, false otherwise.
     */
    @Override
    public boolean onThisDay(String date) {
        LocalDate date1 = LocalDate.parse(date);
        LocalDate byDate = LocalDate.parse(by.format(INPUT_FORMAT).split(" ")[0]);
        return(date1.equals(byDate));
    }

    /**
     * Returns a string representation of the Deadline task.
     *
     * @return A string representing the Deadline task with its description and deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(OUTPUT_FORMAT) + ")";
    }

    /**
     * Returns a string representation of the Deadline task for file storage.
     *
     * @return A string representing the Deadline task in a file-friendly format.
     */
    @Override
    public String toFileString() {
        return "D | " + (super.getStatusIcon()) + " | " + description + " | " + by.format(INPUT_FORMAT);
    }
}