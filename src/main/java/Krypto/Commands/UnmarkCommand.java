package Krypto.Commands;
import Krypto.IO.*;
import Krypto.Utils.*;
public class UnmarkCommand extends Command {
    private int index;
    public UnmarkCommand(int index) {
        this.index = index;
    }
    public void execute(UI ui, TaskList tasks, Storage storage) {
        tasks.getTask(index).unmarkTask();
        storage.store(tasks);
    }
    public  boolean isExit() {
        return false;
    }
}
