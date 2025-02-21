package Krypto;
import Krypto.Commands.Command;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.UI;
import Krypto.IO.Storage;
import Krypto.Utils.Parser;
import Krypto.Utils.TaskList;

/**
 * The main class for the Krypto application.
 * It initializes storage, task management, and user interface, and runs the main event loop.
 */
public class Krypto {
    private static final String FILE_PATH = "src/main/data/Krypto.txt";
    private Storage storage;
    private TaskList tasks;
    private final UI ui;

    /**
     * Initializes a Krypto instance with the specified file path.
     * Loads tasks from storage and sets up the UI.
     *
     * @param filePath The path to the storage file.
     */
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

    /**
     * Runs the main event loop of the Krypto application.
     * Continuously reads user commands and executes them until an exit command is issued.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(ui, tasks, storage);
                isExit = c.isExit();
            } catch (KryptoExceptions e) {
                ui.showError(e);
            }
        }
    }

    /**
     * The main entry point for the Krypto application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Krypto(FILE_PATH).run();
    }
}
