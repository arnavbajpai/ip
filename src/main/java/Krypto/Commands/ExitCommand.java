package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.*;
import Krypto.Utils.*;

public class ExitCommand extends Command{
    public ExitCommand() {}
    @Override
    public  void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions {
        ui.showExit();
    }
    @Override
    public  boolean isExit() {
        return true;
    }
}
