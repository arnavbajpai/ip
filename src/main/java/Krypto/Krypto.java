package Krypto;
import Krypto.Commands.Command;
import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.GUI;
import Krypto.IO.Storage;
import Krypto.Utils.Parser;
import Krypto.Utils.TaskList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main class for the Krypto application.
 * It initializes storage, task management, and user interface, and runs the main event loop.
 */
public class Krypto extends Application{
    private static final String FILE_PATH = "src/main/data/Krypto.txt";
    private Storage storage;
    private TaskList tasks;
    private GUI gui = null;

    private AnchorPane root;
    private final FXMLLoader fxmlLoader;

    /**
     * Initializes a Krypto instance with the specified file path.
     * Loads tasks from storage and sets up the UI.
     *
     * @param filePath The path to the storage file.
     */
    public Krypto(String filePath) {
        fxmlLoader = new FXMLLoader(Krypto.class.getResource("/view/GUI.fxml"));
        try {
            root = fxmlLoader.load();
            gui = fxmlLoader.getController();
            storage = new Storage(filePath);
            tasks = new TaskList(storage.load(), gui);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load GUI.fxml"); // Handle the exception properly
        } catch (KryptoExceptions e) {
            gui.showError(e);
            tasks = new TaskList();
        }
    }
    public Krypto() {
        this(FILE_PATH);
    }

    /**
     * Runs the main event loop of the Krypto application.
     * Continuously reads user commands and executes them until an exit command is issued.
     */

    public void run(String prompt) {
        boolean isExit = false;
        try {
            Command c = Parser.parse(prompt);
            c.execute(gui, tasks, storage);
            isExit = c.isExit();
        } catch (KryptoExceptions e) {
            gui.showError(e);
        }
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        gui.setKrypto(this);
        stage.show();
        gui.showWelcome();
    }
}
