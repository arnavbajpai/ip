package Krypto.Commands;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.*;
import Krypto.Utils.*;
import Krypto.Task.*;
public class AddCommand extends Command {
    private Task newTask;
    public AddCommand(Task task) {
        this.newTask = task;
    }
    @Override
    public void execute(UI ui, TaskList tasks, Storage storage) throws KryptoExceptions {
        tasks.addTask(newTask);
        storage.store(tasks);
    }
    @Override
    public  boolean isExit() {
        return false;
    }
}
