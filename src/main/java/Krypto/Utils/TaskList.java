package Krypto.Utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Krypto.Task.Task;
import Krypto.IO.UI;
public class TaskList {
    private ArrayList<Task> taskList;
    private UI ui;
    private int len;

    /**
     * Initializes a TaskList with an existing list of tasks and a UI object.
     *
     * @param tasks    The list of tasks.
     * @param uiObject The UI object for user interaction.
     */
    public TaskList(ArrayList<Task> tasks, UI uiObject) {
        taskList = tasks;
        ui = uiObject;
        len = tasks.size();
    }

    /**
     * Initializes an empty TaskList.
     */
    public TaskList() {}

    /**
     * Prints the list of tasks.
     */
    public void printList() {
        ui.showLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < len; i++) {
            System.out.printf("%d. %s\n", i + 1, taskList.get(i));
        }
        ui.showLine();
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The length of the task list.
     */
    public int getLength() {
        return len;
    }

    /**
     * Prints tasks that match the specified date.
     *
     * @param date The date to filter tasks by.
     */
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
        if (!found) {
            System.out.println("No tasks on this day!");
        }
        ui.showLine();
    }

    /**
     * Adds a task to the task list.
     *
     * @param t The task to be added.
     */
    public void addTask(Task t) {
        taskList.add(t);
        len++;
        ui.addTaskResponse(t, len);
    }

    /**
     * Returns the task at the specified index.
     *
     * @param index The index of the task.
     * @return The task at the specified index.
     */
    public Task getTask(int index) {
        return taskList.get(index);
    }

    /**
     * Deletes a task from the task list.
     *
     * @param index The index of the task to be deleted.
     */
    public void deleteTask(int index) {
        Task t = taskList.remove(index);
        len--;
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
