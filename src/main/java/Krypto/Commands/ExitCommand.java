package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.*;
import Krypto.Utils.*;

/**
 * Represents a command to exit the application.
 */
public class ExitCommand extends Command {

    /**
     * Constructs an ExitCommand.
     * This constructor does not require any parameters.
     */
    public ExitCommand() {}

    @Override
    public void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions {
        ui.showExit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}