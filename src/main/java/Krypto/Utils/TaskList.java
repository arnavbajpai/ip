package Krypto.Utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Krypto.Task.*;
import Krypto.IO.*;
public class TaskList {
    private ArrayList<Task> taskList;
    private UI ui;

    private int len;

    public TaskList(ArrayList<Task> tasks, UI uiObject) {
        taskList = tasks;
        ui = uiObject;
        len = tasks.size();
    }

    public TaskList(){}
    public void printList() {
        ui.showLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < len; i++) {
            System.out.printf("%d. %s\n", i + 1, taskList.get(i));
        }
        ui.showLine();
    }
    public int getLength() {
        return len;
    }
    public void printShowList(String date) {
        ui.showLine();
        LocalDate queryDate = LocalDate.parse(date);
        boolean found = false;
        System.out.println("Fetching your tasks on " + queryDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
        for (int i = 0; i < len; i++) {
            Task t = taskList.get(i);
            if(t.onThisDay(date)) {
                System.out.printf("%d. %s\n", i + 1, t);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No tasks on this day!");
        }
        ui.showLine();
    }
    public void addTask(Task t) {
        taskList.add(t);
        len ++;
        ui.addTaskResponse(t, len);
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }
    public void deleteTask(int index) {
        Task t = taskList.remove(index);
        len --;
        ui.deleteTaskResponse(t, len);
    }

    public void getTasksWithKeyword(String keyword) {
        ui.showLine();
        boolean found = false;
        System.out.println("Looking for tasks with " + keyword);
        for(int i = 0; i < len; i ++) {
            Task t = taskList.get(i);
            if(t.hasKeyword(keyword)) {
                System.out.printf("%d. %s\n", i + 1, t);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No matches found for " + keyword);
        }
        ui.showLine();
    }
}
