package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class EvenGame {

    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int NUMBER_OF_ROUNDS = 3;

    private static final Random RANDOM = new Random();

    private EvenGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = generateGameRounds();
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateGameRounds() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            int number = RANDOM.nextInt();
            String question = String.valueOf(number);
            String answer = number % 2 == 0 ? "yes" : "no";
            gameRounds.put(question, answer);
        }
        return gameRounds;
    }
}
