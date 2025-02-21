package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.TaskList;
public class DeleteCommand extends Command {
    private final int index;
    public DeleteCommand(int index) {
        this.index = index;
    }
    public void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions {
        tasks.deleteTask(index);
        storage.store(tasks);
    }
    public boolean isExit() {
        return false;
    }
}
