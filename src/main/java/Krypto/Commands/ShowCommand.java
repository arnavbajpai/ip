package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.*;
import Krypto.Utils.*;

public class ShowCommand extends Command{
    private String date;
    public ShowCommand(String date) {
        this.date = date;
    }
    public void execute(UI ui, TaskList tasks, Storage storage)throws KryptoExceptions {
        tasks.printShowList(date);
    }
    public  boolean isExit() {
        return false;
    }
}
