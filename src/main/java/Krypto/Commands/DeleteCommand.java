package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.*;
import Krypto.Utils.*;
public class DeleteCommand extends Command {
    private int index;
    public DeleteCommand(int index) {
        this.index = index;
    }
    public void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions {
        tasks.deleteTask(index);
        storage.store(tasks);
    }
    public  boolean isExit() {
        return false;
    }
}
