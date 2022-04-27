package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.Game;
import hexlet.code.model.Player;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Player player = new Player("Unknown Player");
        Map<Integer, Game> games = new HashMap<>();
        games.put(2, new EvenGame());

        new BrainGames(player, games).launch();
    }
}
