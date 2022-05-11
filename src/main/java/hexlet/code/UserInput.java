package hexlet.code;

import java.util.Scanner;

public final class UserInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private UserInput() {
    }

    public static int getNumber() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String getString() {
        return SCANNER.nextLine();
    }
}
