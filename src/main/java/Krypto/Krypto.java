package Krypto;
import java.io.*;
import Krypto.Commands.*;
import Krypto.Exceptions.*;
import Krypto.IO.*;
import Krypto.Utils.*;

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