package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.TaskList;

public abstract class Command {
    public abstract void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions;
    public abstract boolean isExit();
}
