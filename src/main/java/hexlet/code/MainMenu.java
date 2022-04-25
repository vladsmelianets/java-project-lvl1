package hexlet.code;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class MainMenu {

    private final Player player;

    private final Map<Integer, Game> games;

    MainMenu() {
        player = new Player("Unknown Player");
        games = new HashMap<>();
        games.put(1, new Greeting());
        games.put(2, new EvenCheck());
    }

    public void start() {
        int exit = 0;
        int selection = -1;

        while (selection != exit) {
            games.forEach((key, value) -> out.printf("%d - %s%s", key, value.getName(), lineSeparator()));
            out.printf("%d - Exit%s", exit, lineSeparator());
            selection = Cli.readInt("Your choice: ");
            if (selection != exit) {
                games.get(selection).start(player);
            }
        }
    }
}
