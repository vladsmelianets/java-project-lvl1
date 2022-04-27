package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Game;
import hexlet.code.games.GcdGame;
import hexlet.code.model.Player;

import java.util.HashMap;
import java.util.Map;

public class App {

    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;


    public static void main(String[] args) {
        Player player = new Player("Unknown Player");

        Map<Integer, Game> games = new HashMap<>();
        games.put(TWO, new EvenGame());
        games.put(THREE, new CalcGame());
        games.put(FOUR, new GcdGame());

        new BrainGames(player, games).launch();
    }
}
