package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.TaskList;

public class ListCommand extends Command{

    public ListCommand(){}
    @Override
    public void execute(UI ui, TaskList tasks, Storage storage)throws KryptoExceptions {
        tasks.printList();
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
