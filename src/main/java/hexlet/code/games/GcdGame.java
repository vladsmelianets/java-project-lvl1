package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class GcdGame {

    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int NUMBER_OF_ROUNDS = 3;

    private static final Random RANDOM = new Random();
    private static final int TWO_DIGIT_BOUND = 100;

    private GcdGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = generateGameRounds();
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateGameRounds() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            int firstNum = RANDOM.nextInt(TWO_DIGIT_BOUND);
            int secondNum = RANDOM.nextInt(TWO_DIGIT_BOUND);
            String question = firstNum + " " + secondNum;
            String answer = String.valueOf(calcGcd(firstNum, secondNum));
            gameRounds.put(question, answer);
        }
        return gameRounds;
    }

    private static int calcGcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return calcGcd(second, first % second);
    }
}
