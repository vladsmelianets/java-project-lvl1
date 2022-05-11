package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberUtils;

import java.util.HashMap;
import java.util.Map;

public final class PrimeGame {

    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int NUMBER_OF_ROUNDS = 3;

    private PrimeGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = generateGameRounds();
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateGameRounds() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            int number = RandomNumberUtils.getThreeDigitNumber();
            String question = String.valueOf(number);
            String answer = isPrime(number) ? "yes" : "no";
            gameRounds.put(question, answer);
        }
        return gameRounds;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
