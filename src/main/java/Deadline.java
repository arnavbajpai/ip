public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(extractContent(description.split("/")[0].split(" ")));
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(" + by + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}
