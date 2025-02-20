import java.io.*;
public class Krypto {
    private static final String FILE_PATH = "src/main/data/Krypto.txt";
    private final Storage storage;
    private TaskList tasks;
    private final UI ui;
    public Krypto(String filePath) {
        ui = new UI();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load(), ui);
        } catch (FileNotFoundException e) {
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