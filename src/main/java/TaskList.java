import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
                System.out.printf("%d. %s\n", i + 1, taskList.get(i));
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
}
