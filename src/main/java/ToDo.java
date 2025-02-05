public class ToDo extends Task {


    public ToDo(String description) {
        super(extractContent(description.split("/")[0].split(" ")));
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
