package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberUtils;

import java.util.HashMap;
import java.util.Map;

public final class EvenGame {

    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private EvenGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            int number = RandomNumberUtils.getNumber();
            gameRounds.putAll(generateRound(number));
        }
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateRound(int number) {
        Map<String, String> round = new HashMap<>();
        String question = String.valueOf(number);
        String answer = number % 2 == 0 ? "yes" : "no";
        round.put(question, answer);
        return round;
    }
}
