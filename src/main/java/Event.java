public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(extractContent(description.split("/")[0].split(" ")));
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(" +  this.from + this.to + ")";
    }
}
