public abstract class Command {
    public abstract void execute(UI ui, TaskList tasks, Storage storage);
    public abstract boolean isExit();
}
