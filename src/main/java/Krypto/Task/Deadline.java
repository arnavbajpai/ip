package Krypto.Task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    private final LocalDateTime by;

    public Deadline(String description, String by) throws DateTimeParseException {
        super(extractContent(description.split("/")[0].split(" ")));
        this.by = LocalDateTime.parse(by, INPUT_FORMAT);
    }
    @Override
    public boolean onThisDay(String date) {
        LocalDate date1 = LocalDate.parse(date);
        LocalDate byDate = LocalDate.parse(by.format(INPUT_FORMAT).split(" ")[0]);
        return(date1.equals(byDate));
    }
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (super.getStatusIcon()) + " | " + description + " | " + by.format(INPUT_FORMAT);
    }
}