import java.util.ArrayList;
import java.util.Scanner;
public class Krypto {
   static String line = "-".repeat(100);
    private static String printResponse(ArrayList<Task> lst) {
        int len = lst.size();
        return String.format("Got it. I've added this task :  %s\n" +
                        "Now you have %d tasks in the list."
                , lst.get(len-1), len);
    }

    public static void printList(ArrayList<Task> lst) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < lst.size() ; i ++) {
            System.out.printf("%d. %s\n", i + 1, lst.get(i));
        }
        System.out.println(line);
    }

    public static void printResponseWithLines(String resp) {
        System.out.println(line);
        System.out.println(resp);
        System.out.println(line);
    }
    public static void main(String[] args) {
        printResponseWithLines("Hello, I'm Krypto \nWhat can I do for you ?");
        ArrayList<Task> arr = new ArrayList<Task>();
        Scanner myObj = new Scanner(System.in);
        while(true) {
            String prompt = myObj.nextLine();
            String [] split = prompt.split(" ");
            String first = split[0];
            if (prompt.equals("bye")) {
                printResponseWithLines("Great talking to you!");
                break;
            }
            else if (prompt.equals("list")) {
                printList(arr);
                continue;
            }
            else if (first.equals("mark")) {
                int id = Integer.parseInt(split[1]);
                arr.get(id-1).markTask();
                continue;
            }
            else if (first.equals("unmark")) {
                int id = Integer.parseInt(split[1]);
                arr.get(id-1).unmarkTask();
                continue;
            }
            else if (first.equals("delete")) {
                int id = Integer.parseInt(split[1]);
                arr.remove(id -1);
                printResponseWithLines(String.format("Deleted succesfully." +
                        " There are now %d tasks remaining in your list.", arr.size()));
                continue;
            }
            try {
                if(checkValid(split)) {
                    Task newTask = getTask(prompt, split);
                    arr.add(newTask);
                    printResponseWithLines(printResponse(arr));
                }
            }
            catch(KryptoExceptions e) {
               printResponseWithLines(e.toString());
            }
        }
    }

    private static Boolean checkValid(String[] split) throws KryptoExceptions {
       String cmd = split[0];
       Boolean resp =  cmd.equals("todo") || cmd.equals("event") || cmd.equals("deadline");
       if(!resp) {
           throw new InvalidCommand(cmd);
       }
       return resp;
    }
    private static Task getTask(String prompt, String[] split) throws KryptoExceptions {
        Task newTask;
        String [] parts = prompt.split("/");
        String type = split[0];
        if(type.equals("todo")) {
            if (parts.length > 1) {
                throw new ToDoException();
            }
            if (split.length <= 1) {
                throw new IncompleteCommand(type);
            }
            newTask = new ToDo(prompt);
        }
        else if (type.equals("deadline")) {
            if (parts.length != 2) {
                throw new IncompleteCommand(type);
            }
            newTask = new Deadline(prompt, parts[1]);
        }
        else {
            if (parts.length != 3) {
                throw new IncompleteCommand(type);
            }
            newTask = new Event(prompt, parts[1], parts[2]);
        }
        return newTask;
    }
}
