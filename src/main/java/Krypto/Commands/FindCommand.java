package Krypto.Commands;

import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.Storage;
import Krypto.IO.UI;
import Krypto.Utils.TaskList;

public class FindCommand extends Command {

    private final String keyword;
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }
    @Override
    public void execute(UI ui, TaskList tasks, Storage storage)throws KryptoExceptions {
        tasks.getTasksWithKeyword(keyword);
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
