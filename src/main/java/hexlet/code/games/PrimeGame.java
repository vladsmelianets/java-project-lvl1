package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberUtils;

import java.util.HashMap;
import java.util.Map;

public final class PrimeGame {

    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private PrimeGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            int number = RandomNumberUtils.getThreeDigitNumber();
            gameRounds.putAll(generateRound(number));
        }
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateRound(int number) {
        Map<String, String> round = new HashMap<>();
        String question = String.valueOf(number);
        String answer = isPrime(number) ? "yes" : "no";
        round.put(question, answer);
        return round;
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
