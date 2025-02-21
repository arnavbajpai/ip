package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.TaskList;
/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * Constructs a DeleteCommand with the specified task index.
     *
     * @param index The index of the task to delete.
     */
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