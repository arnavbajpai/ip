package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.TaskList;

public class ExitCommand extends Command{
    public ExitCommand() {}
    @Override
    public  void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions {
        ui.showExit();
    }
    @Override
    public boolean isExit() {
        return true;
    }
}
