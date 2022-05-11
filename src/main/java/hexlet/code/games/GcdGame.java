package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberUtils;

import java.util.HashMap;
import java.util.Map;

public final class GcdGame {

    private static final String RULES = "Find the greatest common divisor of given numbers.";

    private GcdGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            int firstNum = RandomNumberUtils.getTwoDigitNumber();
            int secondNum = RandomNumberUtils.getTwoDigitNumber();
            gameRounds.putAll(generateRound(firstNum, secondNum));
        }
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateRound(int firstNum, int secondNum) {
        Map<String, String> round = new HashMap<>();
        String question = firstNum + " " + secondNum;
        String answer = String.valueOf(gcd(firstNum, secondNum));
        round.put(question, answer);
        return round;
    }

    private static int gcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcd(second, first % second);
    }
}
