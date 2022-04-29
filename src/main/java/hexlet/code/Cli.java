package hexlet.code;

import java.util.Scanner;

public class Cli {

    private Cli() {
    }

    public static String greet() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
