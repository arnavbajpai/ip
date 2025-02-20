package Krypto.IO;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import Krypto.Task.*;
import Krypto.Utils.*;
public class Storage {

    private final File file;
    private final String pathName;

    public Storage(String pathName) {
        this.file = new File(pathName);
        this.pathName = pathName;
    }
    public ArrayList<Task> load() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task newTask = Parser.parseStorage(line);
                tasks.add(newTask);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error loading tasks: File not found.");
        }
        return tasks;
    }

    public void store(TaskList tasks) {
        int len = tasks.getLength();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathName))) {
            for (int i = 0; i < len; i++) {
                writer.write(tasks.getTask(i).toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
