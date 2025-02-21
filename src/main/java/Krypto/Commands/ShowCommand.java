package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.TaskList;
public class ShowCommand extends Command {
    private final String date;
    public ShowCommand(String date) {
        this.date = date;
    }
    public void execute(UI ui, TaskList tasks, Storage storage)throws KryptoExceptions {
        tasks.printShowList(date);
    }
    public boolean isExit() {
        return false;
    }
}
