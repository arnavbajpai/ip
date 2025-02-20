package Krypto.Commands;
import Krypto.IO.*;
import Krypto.Utils.*;

public class MarkCommand extends Command {
    private int index;
    public MarkCommand(int index) {
        this.index = index;

    }
    public void execute(UI ui, TaskList tasks, Storage storage) {
        tasks.getTask(index).markTask();
        storage.store(tasks);
    }
    public  boolean isExit() {
        return false;
    }
}
