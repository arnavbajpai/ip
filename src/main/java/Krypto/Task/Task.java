package Krypto.Task;
public class Task {
    protected String description;
    protected boolean isDone = false;

    private String sign = "";

    public Task(String description) {
        this.description = description;
    }
    public boolean onThisDay(String date) {
        return false;
    }
    public static String extractContent(String[] prompt) {
        StringBuilder content = new StringBuilder();
        if (prompt.length <= 1) {
            return "";
        }
        for(int i = 1; i < prompt.length; i ++) {
            if(i != prompt.length - 1) {
                content.append(prompt[i]).append(" ");
                continue;
            }
            content.append(prompt[i]);
        }
        return content.toString();
    }
    public void markTask() {
        this.isDone = true;
        this.sign = "X";
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(this);
    }

    public void markTask(boolean print) {
        this.isDone = true;
        this.sign = "X";
        if(print) {
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(this);
        }
    }
    public void unmarkTask() {
        this.isDone = false;
        this.sign = "";
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(this);
    }
    public String getStatusIcon() {
        return this.sign;
    }

    public String getDescription() {return this.description; }

    public String toFileString() {
        return "";
    }

    public boolean hasKeyword(String keyword) {
        String[] parts = description.split(" ");
        for(int i = 0; i < parts.length; i ++) {
            if(keyword.equals(parts[i])) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "[" + this.sign + "] " + this.description;
    }
}
