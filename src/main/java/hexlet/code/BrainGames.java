package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.model.Player;
import hexlet.code.utils.Cli;

import java.util.Map;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class BrainGames {

    public static final int EXIT = 0;
    public static final int GREET = 1;
    public static final int GUESSES_TO_WIN = 3;

    private final Player player;
    private final Map<Integer, Game> games;

    public BrainGames(Player player, Map<Integer, Game> games) {
        this.player = player;
        this.games = games;
    }

    public void launch() {
        int selection = -1;
        while (selection != EXIT) {
            displayOptions();
            selection = Cli.readInt("Your choice: ");

            if (selection == GREET) {
                new PlayerService().greet(player);
            } else if (selection != EXIT) {
                new Engine(player, GUESSES_TO_WIN).start(games.get(selection));
            }
        }
    }

    private void displayOptions() {
        out.println("Please enter the game number and press Enter.");
        out.printf("%d - Greet%s", GREET, lineSeparator());
        games.forEach((key, value) -> out.printf("%d - %s%s", key, value.getName(), lineSeparator()));
        out.printf("%d - Exit%s", EXIT, lineSeparator());
    }
}
