package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.TaskList;

/**
 * Represents a command to mark a task as completed.
 */
public class MarkCommand extends Command {
    private final int index;

    /**
     * Constructs a MarkCommand with the specified task index.
     *
     * @param index The index of the task to mark as completed.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    public void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions {
        tasks.getTask(index).markTask();
        storage.store(tasks);
    }

    public boolean isExit() {
        return false;
    }
}