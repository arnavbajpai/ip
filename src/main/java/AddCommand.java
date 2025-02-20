public class AddCommand extends Command {
    private Task newTask;
    public AddCommand(Task task) {
        this.newTask = task;
    }
    @Override
    public void execute(UI ui, TaskList tasks, Storage storage) {
        tasks.addTask(newTask);
        storage.store(tasks);
    }
    @Override
    public  boolean isExit() {
        return false;
    }
}
