package Krypto.Task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Represents an event task with a start and end date/time.
 */
public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy ha");

    /**
     * Constructs an Event task with the specified description, start, and end time.
     *
     * @param description The description of the event.
     * @param from The start date and time in "yyyy-MM-dd HH:mm" format.
     * @param to The end date and time in "yyyy-MM-dd HH:mm" format.
     * @throws DateTimeParseException If the date format is incorrect.
     */
    public Event(String description, String from, String to) throws DateTimeParseException {
        super(extractContent(description.split("/")[0].split(" ")));
        this.from = LocalDateTime.parse(from, INPUT_FORMAT);
        this.to = LocalDateTime.parse(to, INPUT_FORMAT);
    }

    /**
     * Returns the string representation of the Event task.
     *
     * @return A formatted string representing the Event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from " + from.format(OUTPUT_FORMAT) + " - to " + to.format(OUTPUT_FORMAT) + ")";
    }

    /**
     * Checks if the event occurs on the specified date.
     *
     * @param date The date to check.
     * @return True if the event falls on the given date, false otherwise.
     */
    @Override
    public boolean onThisDay(String date) {
        LocalDate date1 = LocalDate.parse(date);
        LocalDate fromDate = LocalDate.parse(from.format(INPUT_FORMAT).split(" ")[0]);
        LocalDate toDate = LocalDate.parse(to.format(INPUT_FORMAT).split(" ")[0]);
        return (date1.equals(fromDate) || date1.equals(toDate));
    }

    /**
     * Converts the Event task to a string format suitable for file storage.
     *
     * @return A string representation of the Event task for file storage.
     */
    @Override
    public String toFileString() {
        return "E | " + (super.getStatusIcon()) + " | " + description + " | " + from.format(INPUT_FORMAT) + " | " + to.format(INPUT_FORMAT);
    }
}
