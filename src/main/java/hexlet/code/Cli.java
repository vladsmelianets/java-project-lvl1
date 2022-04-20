package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner scanner = new Scanner(System.in);

    private Cli() {
    }

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        String name = getString("May I have your name?");
        System.out.printf("Hello, %s!%s", name, System.lineSeparator());
    }

    private static String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
