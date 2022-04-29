package hexlet.code.utils;

import java.util.Scanner;

public final class CliHelper {

    private CliHelper() {
    }

    public static String readString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int readInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
    }
}
