package Krypto.IO;
import java.util.Scanner;
import Krypto.Task.Task;

/**
 * Handles user interface interactions, displaying messages and reading user input.
 */
public class UI {

    private static final String HORIZONTAL_LINE = "-".repeat(100);
    private final Scanner myObj;

    /**
     * Constructs a UI object that initializes the scanner for reading user input.
     */
    public UI() {
        myObj = new Scanner(System.in);
    }

    public void showLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    public void showError(Exception e) {
        printResponseWithLines(e.toString());
    }

    public void showExit() {
        printResponseWithLines("Great talking to you!");
    }

    public void showWelcome() {
        printResponseWithLines("Hello, I'm Krypto \nWhat can I do for you?");
    }

    /**
     * Reads a command from the user input.
     *
     * @return The command input by the user.
     */
    public String readCommand() {
        return myObj.nextLine();
    }

    /**
     * Displays a response after adding a task.
     *
     * @param t The task that was added.
     * @param len The current number of tasks in the list.
     */
    public void addTaskResponse(Task t, int len) {
        printResponseWithLines(String.format("Got it. I've added this task :  %s\nNow you have %d tasks in the list.", t, len));
    }

    /**
     * Displays a response after deleting a task.
     *
     * @param t The task that was removed.
     * @param len The current number of tasks in the list.
     */
    public void deleteTaskResponse(Task t, int len) {
        printResponseWithLines(String.format("Got it. I've removed this task :  %s\nNow you have %d tasks in the list.", t, len));
    }

    /**
     * Prints the given response with horizontal lines surrounding it.
     *
     * @param resp The response message to print.
     */

    public static void printResponseWithLines(String resp) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(resp);
        System.out.println(HORIZONTAL_LINE);
    }
}