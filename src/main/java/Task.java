public class Task {
    protected String description;
    protected boolean isDone = false;

    private String sign = "";

    public Task(String description) {
        this.description = description;
    }

    public void markTask() {
        this.isDone = true;
        this.sign = "X";
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(this.toString());
    }
    public void unmarkTask() {
        this.isDone = false;
        this.sign = "";
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(this.toString());
    }
    public String getStatusIcon() {
        return this.sign;
    }
    @Override
    public String toString() {
        return "[" + this.sign + "] " + this.description;
    }
}
