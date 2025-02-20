public class ListCommand extends Command{

    public ListCommand(){}
    @Override
    public void execute(UI ui, TaskList tasks, Storage storage) {
        tasks.printList();
    }
    @Override
    public  boolean isExit() {
        return false;
    }
}
