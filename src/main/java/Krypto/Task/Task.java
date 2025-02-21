package Krypto.Task;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a description and completion status.
 */

public class Task {
    protected String description;
    protected boolean isDone = false;
    protected static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    protected static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy ha");
    private String sign = "";

    /**
     * Constructs a Task with the specified description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
    }

    /**
     * Checks if the task is scheduled for the given date.
     *
     * @param date The date to check.
     * @return Always returns false as a generic task has no date.
     */
    public boolean onThisDay(String date) {
        return false;
    }

    /**
     * Extracts the content from a given array of prompt strings.
     *
     * @param prompt The array of strings representing the user input.
     * @return The extracted content as a single string.
     */
    public static String extractContent(String[] prompt) {
        StringBuilder content = new StringBuilder();
        if (prompt.length <= 1) {
            return "";
        }
        for (int i = 1; i < prompt.length; i++) {
            if (i != prompt.length - 1) {
                content.append(prompt[i]).append(" ");
                continue;
            }
            content.append(prompt[i]);
        }
        return content.toString();
    }

    /**
     * Marks the task as completed and updates its status icon.
     */
    public void markTask() {
        this.isDone = true;
        this.sign = "X";
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(this);
    }

    /**
     * Marks the task as completed and updates its status icon.
     *
     * @param print Whether to print the task status.
     */
    public void markTask(boolean print) {
        this.isDone = true;
        this.sign = "X";
        if (print) {
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(this);
        }
    }

    /**
     * Unmarks the task as not completed and updates its status icon.
     */
    public void unmarkTask() {
        this.isDone = false;
        this.sign = "";
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(this);
    }

    public String getStatusIcon() {
        return this.sign;
    }

    public String getDescription() {
        return this.description;
    }

    public String toFileString() {
        return "";
    }

    @Override
    public String toString() {
        return "[" + this.sign + "] " + this.description;
    }
}
