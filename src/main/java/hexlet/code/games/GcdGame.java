package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberUtils;

import java.util.HashMap;
import java.util.Map;

public final class GcdGame {

    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int NUMBER_OF_ROUNDS = 3;

    private GcdGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = generateGameRounds();
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateGameRounds() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            int firstNum = RandomNumberUtils.getTwoDigitNumber();
            int secondNum = RandomNumberUtils.getTwoDigitNumber();
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
