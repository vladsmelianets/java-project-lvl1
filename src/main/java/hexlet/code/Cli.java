package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner scanner = new Scanner(System.in);

    private Cli() {
    }

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        String name = getString("May I have your name?");
        System.out.println("Hello, " + name);
    }

    private static String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
