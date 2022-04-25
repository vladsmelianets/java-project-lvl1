package hexlet.code;

import java.util.Scanner;

public final class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Cli() {
    }

    public static String readString(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }

    public static int readInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int readInt(String message) {
        System.out.print(message);
        return readInt();
    }
}
