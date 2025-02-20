package Krypto.Utils;

import Krypto.Task.ToDo;
import Krypto.Task.Task;
import Krypto.IO.UI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    private TaskList taskList;
    private UI mockUI;

    @BeforeEach
    public void setUp() {
        mockUI = new UI();
        taskList = new TaskList(new ArrayList<>(), mockUI);
    }

    @Test
    public void testAddTask() {
        Task task = new ToDo("todo read book");
        taskList.addTask(task);
        assertEquals(1, taskList.getLength());
        assertEquals("read book", taskList.getTask(0).getDescription());
    }

    @Test
    public void testDeleteTask() {
        Task task1 = new ToDo("todo read book");
        Task task2 = new ToDo("todo write notes");
        taskList.addTask(task1);
        taskList.addTask(task2);

        taskList.deleteTask(0);
        assertEquals(1, taskList.getLength());
        assertEquals("write notes", taskList.getTask(0).getDescription());
    }

    @Test
    public void testGetTask() {
        Task task = new ToDo("todo exercise");
        taskList.addTask(task);
        Task retrieved = taskList.getTask(0);
        assertEquals("exercise", retrieved.getDescription());
    }

    @Test
    public void testEmptyTaskList() {
        assertEquals(0, taskList.getLength());
    }
}