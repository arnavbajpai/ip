import java.util.Scanner;
public class Krypto {
   static String line = "-".repeat(100);



    public static void  printResponse(String input) {
        System.out.println(line);
        System.out.printf("Added :  %s\n", input);
        System.out.println(line);
    }
    public static void main(String[] args) {
        System.out.println(line);
        System.out.println("Hello, I'm Krypto \nWhat can I do for you ?");
        System.out.println(line);
        String[] arr = new String[100];
        int ctr = 0;
        Scanner myObj = new Scanner(System.in);
        while(true) {
            String prompt = myObj.nextLine();
            if (prompt.equals("bye")) {
                break;
            }
            else if (prompt.equals("list")) {
                for(int i = 0; i < ctr ; i ++) {
                    System.out.printf("%d. %s\n", i + 1, arr[i]);
                }
                continue;
            }
            arr[ctr] = prompt;
            ctr ++;
            printResponse(prompt);
        }

    }
}
