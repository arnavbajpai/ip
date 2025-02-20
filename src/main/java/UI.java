import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static final String HORIZONTAL_LINE = "-".repeat(100);
    private Scanner myObj;
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
    public void printList(ArrayList<Task> lst) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < lst.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, lst.get(i));
        }
        System.out.println(HORIZONTAL_LINE);
    }

    public void printList(ArrayList<Task> lst, String date) {
        System.out.println(HORIZONTAL_LINE);
        LocalDate queryDate = LocalDate.parse(date);
        boolean found = false;
        System.out.println("Finding tasks on " + queryDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
        for (int i = 0; i < lst.size(); i++) {
            Task t = lst.get(i);
            if(t.onThisDay(date)) {
                System.out.printf("%d. %s\n", i + 1, lst.get(i));
                found = true;
            }
        }
        if(!found) {
            System.out.println("No tasks on this day!");
        }
        System.out.println(HORIZONTAL_LINE);
    }

    public static void printResponseWithLines(String resp) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(resp);
        System.out.println(HORIZONTAL_LINE);
    }
}
