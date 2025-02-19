import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy ha");

    public Event(String description, String from, String to) {
        super(extractContent(description.split("/")[0].split(" ")));
        this.from = LocalDateTime.parse(from, INPUT_FORMAT);
        this.to = LocalDateTime.parse(to, INPUT_FORMAT);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from " +  from.format(OUTPUT_FORMAT) + " - to " +  to.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from.format(INPUT_FORMAT) + " | " + to.format(INPUT_FORMAT);
    }
}
