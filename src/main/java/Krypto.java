import java.util.Scanner;
public class Krypto {
   static String line = "-".repeat(100);

    public static void  printResponse(Task[] lst, int ctr) {
        int len = lst.length;
        System.out.println(line);
        System.out.printf("Got it. I've added this task :  %s\n", lst[ctr -1]);
        System.out.printf("Now you have %d tasks in the list.\n", ctr);
        System.out.println(line);
    }

    public static void printList(Task[] lst) {
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; lst[i] != null ; i ++) {
            System.out.printf("%d. %s\n", i + 1, lst[i].toString());
        }
    }


    public static void main(String[] args) {
        System.out.println(line);
        System.out.println("Hello, I'm Krypto \nWhat can I do for you ?");
        System.out.println(line);
        Task[] arr = new Task[100];
        int ctr = 0;
        Scanner myObj = new Scanner(System.in);
        while(true) {
            String prompt = myObj.nextLine();
            String [] split = prompt.split(" ");
            String first = split[0];
            if (prompt.equals("bye")) {
                break;
            }
            else if (prompt.equals("list")) {
                printList(arr);
                continue;
            }
            else if (first.equals("mark")) {
                int id = Integer.parseInt(split[1]);
                Task t = arr[id - 1];
                t.markTask();
                continue;
            }
            else if (first.equals("unmark")) {
                int id = Integer.parseInt(split[1]);
                Task t = arr[id - 1];
                t.unmarkTask();
                continue;
            }
            Task newTask = getTask(prompt, split);
            arr[ctr] = newTask;
            ctr ++;
            printResponse(arr, ctr);
        }

    }

    private static Task getTask(String prompt, String[] split) {
        Task newTask;
        String [] parts = prompt.split("/");
        if (parts.length == 1) {
            if (split[0].equals("todo")) {
                newTask = new ToDo(prompt);
            }
            else {
                newTask = new Task(prompt);
            }
        }
        else if (parts.length == 2) {
            newTask = new Deadline(parts[0], parts[1]);
        }
        else {
            newTask = new Event(parts[0], parts[1], parts[2]);
        }
        return newTask;
    }
}
