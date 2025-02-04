import java.util.Scanner;
public class Krypto {
   static String line = "-".repeat(100);

    public static void  printResponse(Task input) {
        System.out.println(line);
        System.out.printf("Added :  %s\n", input);
        System.out.println(line);
    }

    public static void printList(Task[] lst, int ctr) {
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < ctr ; i ++) {
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
                printList(arr, ctr);
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
            Task newTask = new Task(prompt);
            arr[ctr] = newTask;
            ctr ++;
            printResponse(newTask);
        }

    }
}
