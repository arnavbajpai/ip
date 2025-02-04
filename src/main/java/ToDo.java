public class ToDo extends Task {


    public ToDo(String description) {
        super(extractContent(description.split(" ")));
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
