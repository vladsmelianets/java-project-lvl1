package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Game;
import hexlet.code.games.GcdGame;
import hexlet.code.utils.CliHelper;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class App {

    public static final int EXIT = 0;
    public static final int GREET = 1;

    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    public static void main(String[] args) {
        String playerName = "Unknown Player";

        Map<Integer, Game> games = new HashMap<>();
        games.put(TWO, new EvenGame());
        games.put(THREE, new CalcGame());
        games.put(FOUR, new GcdGame());

        int selection = -1;
        while (selection != EXIT) {

            out.println("Please enter the game number and press Enter.");
            out.printf("%d - Greet%s", GREET, lineSeparator());
            games.forEach((key, value) -> out.printf("%d - %s%s", key, value.getName(), lineSeparator()));
            out.printf("%d - Exit%s", EXIT, lineSeparator());

            selection = CliHelper.readInt("Your choice: ");

            if (selection == GREET) {
                playerName = Cli.greet();
            } else if (selection != EXIT) {
                new Engine(playerName).start(games.get(selection));
            }
        }
    }
}
