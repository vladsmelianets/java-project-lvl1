package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Game;
import hexlet.code.model.Player;

import java.util.HashMap;
import java.util.Map;

public class App {

    private static final int ONE = 1;
    private static final int TWO = 2;

    public static void main(String[] args) {
        Player player = new Player("Unknown Player");

        Map<Integer, Game> games = new HashMap<>();
        games.put(ONE, new EvenGame());
        games.put(TWO, new CalcGame());

        new BrainGames(player, games).launch();
    }
}
