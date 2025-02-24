package Krypto.Utils;

import Krypto.Exceptions.KryptoExceptions;
import Krypto.IO.GUI;
import Krypto.Task.ToDo;
import Krypto.Task.Task;
import Krypto.IO.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    private TaskList taskList;
    private GUI mockUI;

    @BeforeEach
    public void setUp() {
        mockUI = new GUI();
        taskList = new TaskList(new ArrayList<>(), mockUI);
    }
/*
    @Test
    public void testAddTask() {
        Task task = new ToDo("todo read book");
        try {
            taskList.addTask(task);
            assertEquals(1, taskList.getLength());
            assertEquals("read book", taskList.getTask(0).getDescription());
        } catch(KryptoExceptions e) {
            System.out.println("Invalid index");
        }
    }

    @Test
    public void testDeleteTask() {
        Task task1 = new ToDo("todo read book");
        Task task2 = new ToDo("todo write notes");
        taskList.addTask(task1);
        taskList.addTask(task2);
        try {
            taskList.deleteTask(0);
            assertEquals(1, taskList.getLength());
            assertEquals("write notes", taskList.getTask(0).getDescription());
        } catch(KryptoExceptions e) {
            System.out.println("Invalid index");
        }

    }

    @Test
    public void testGetTask() {
        Task task = new ToDo("todo exercise");
        taskList.addTask(task);
        try {
            Task retrieved = taskList.getTask(0);
            assertEquals("exercise", retrieved.getDescription());
        } catch (KryptoExceptions e) {
            System.out.println("Invalid index");
        }
    }
*/
    @Test
    public void testEmptyTaskList() {
        assertEquals(0, taskList.getLength());
    }
}