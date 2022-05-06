package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

import static java.lang.String.format;
import static java.lang.System.lineSeparator;

public class App {

    public static final int EXIT = 0;
    public static final int GREET = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;

    private static final String MENU = "Please enter the game number and press Enter." + lineSeparator()
            + format("%d - Greet%s", GREET, lineSeparator())
            + format("%d - Even%s", EVEN, lineSeparator())
            + format("%d - Calc%s", CALC, lineSeparator())
            + format("%d - GCD%s", GCD, lineSeparator())
            + format("%d - Progression%s", PROGRESSION, lineSeparator())
            + format("%d - Prime%s", PRIME, lineSeparator())
            + format("%d - Exit%s", EXIT, lineSeparator());

    public static void main(String[] args) {
        System.out.print(MENU);
        int selection = new Scanner(System.in).nextInt();

        switch (selection) {
            case (GREET):
                Cli.greet();
                break;
            case (EVEN):
                EvenGame.play();
                break;
            case (CALC):
                CalcGame.play();
                break;
            case (GCD):
                GcdGame.play();
                break;
            case (PROGRESSION):
                ProgressionGame.play();
                break;
            case (PRIME):
                PrimeGame.play();
                break;
            default:
                break;
        }
    }
}
