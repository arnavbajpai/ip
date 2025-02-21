package Krypto;
import Krypto.Commands.Command;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.Parser;
import Krypto.Utils.TaskList;

public class Krypto {
    private static final String FILE_PATH = "src/main/data/Krypto.txt";
    private Storage storage;
    private TaskList tasks;
    private final UI ui;
    public Krypto(String filePath) {
        ui = new UI();
        try {
            storage = new Storage(filePath);
            tasks = new TaskList(storage.load(), ui);
        } catch (KryptoExceptions e) {
            ui.showError(e);
            tasks = new TaskList();
        }
    }
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(ui, tasks,  storage);
                isExit = c.isExit();
            } catch (KryptoExceptions e) {
                ui.showError(e);
            }
        }
    }
    public static void main(String[] args) {
        new Krypto(FILE_PATH).run();
    }
}