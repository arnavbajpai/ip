package Krypto.Task;


public class ToDo extends Task {
    public ToDo(String description) {
        super(extractContent(description.split("/")[0].split(" ")));
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFileString() {
        return "T | " + (super.getStatusIcon()) + " | " + description;
    }

}
