public class ExitCommand extends Command{
    public ExitCommand() {}
    @Override
    public  void execute(UI ui, TaskList tasks, Storage storage) {
        ui.showExit();
    }
    @Override
    public  boolean isExit() {
        return true;
    }
}
