import java.util.Scanner;
public class Krypto {
   static  String line = "-".repeat(100);

    public static void  printResponse(String input) {
        System.out.println(line);
        System.out.println(input);
        System.out.println(line);
    }
    public static void main(String[] args) {
        System.out.println(line);
        System.out.println("Hello, I'm Krypto \nWhat can I do for you ?");
        System.out.println(line);
        Scanner myObj = new Scanner(System.in);
        while(true) {
            String prompt = myObj.nextLine();
            if (prompt.equals("bye")) {
                break;
            }
            printResponse(prompt);
        }

    }
}
