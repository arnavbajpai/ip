package Krypto.IO;
import java.util.Scanner;
import Krypto.Task.Task;

public class UI {
    private static final String HORIZONTAL_LINE = "-".repeat(100);
    private final Scanner myObj;
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

    public String readCommand() {
        return myObj.nextLine();
    }

    public void addTaskResponse(Task t, int len) {
        printResponseWithLines(String.format("Got it. I've added this task :  %s\nNow you have %d tasks in the list.", t, len));
    }
    public void deleteTaskResponse(Task t, int len) {
        printResponseWithLines(String.format("Got it. I've removed this task :  %s\nNow you have %d tasks in the list.", t, len));
    }
    public static void printResponseWithLines(String resp) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(resp);
        System.out.println(HORIZONTAL_LINE);
    }
}
