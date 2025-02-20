package Krypto.IO;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Krypto.Exceptions.KryptoExceptions;
import Krypto.Task.*;
import Krypto.Utils.*;
public class Storage {

    private final File file;
    private final String pathName;

    private static final String FILE_WRITE_EXCEPTION = "File could not be written.";
    private static final String FILE_READ_EXCEPTION = "File could not be read.";
    private static final String FILE_NOT_CREATED_EXCEPTION = "Target file could not be created.";

    public Storage(String pathName) throws KryptoExceptions{
        this.file = new File(pathName);
        this.pathName = pathName;
        if(!file.exists()) {
            System.out.println("File not found. Creating new file.....");
            createFile();
        }
    }
    private void createFile() throws KryptoExceptions{
        try {
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            file.createNewFile();
        } catch (IOException e) {
            throw new KryptoExceptions(FILE_NOT_CREATED_EXCEPTION);
        }
    }
    public ArrayList<Task> load() throws KryptoExceptions {
        ArrayList<Task> tasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task newTask = Parser.parseStorage(line);
                tasks.add(newTask);
            }
        } catch (FileNotFoundException e) {
            throw new KryptoExceptions(FILE_READ_EXCEPTION);
        }
        return tasks;
    }

    public void store(TaskList tasks) throws KryptoExceptions {
        int len = tasks.getLength();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathName))) {
            for (int i = 0; i < len; i++) {
                writer.write(tasks.getTask(i).toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new KryptoExceptions(FILE_WRITE_EXCEPTION);
        }
    }
}
