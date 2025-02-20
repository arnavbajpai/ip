package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.*;
import Krypto.Utils.*;
/**
 * Represents a command to unmark a task as completed.
 */
public class UnmarkCommand extends Command {

    private int index;

    /**
     * Constructs an UnmarkCommand with the specified task index.
     *
     * @param index The index of the task to unmark.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }


    public void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions {
        tasks.getTask(index).unmarkTask();
        storage.store(tasks);
    }
    public boolean isExit() {
        return false;
    }
}