package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.*;
import Krypto.Utils.*;

/**
 * Represents a command to show tasks for a specific date.
 */
public class ShowCommand extends Command {

    private String date;

    /**
     * Constructs a ShowCommand with the specified date.
     *
     * @param date The date for which to display the tasks.
     */
    public ShowCommand(String date) {
        this.date = date;
    }

    public void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions {
        tasks.printShowList(date);
    }

    public boolean isExit() {
        return false;
    }
}