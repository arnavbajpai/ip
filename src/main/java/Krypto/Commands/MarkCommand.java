package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.TaskList;

public class MarkCommand extends Command {
    private final int index;
    public MarkCommand(int index) {
        this.index = index;
    }
    public void execute(UI ui, TaskList tasks, Storage storage)throws KryptoExceptions {
        tasks.getTask(index).markTask();
        storage.store(tasks);
    }
    public  boolean isExit() {
        return false;
    }
}
