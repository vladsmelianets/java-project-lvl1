package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberUtils;

import java.util.HashMap;
import java.util.Map;

public final class ProgressionGame {

    private static final String RULES = "What number is missing in the progression?";
    private static final int LOW_DICE = 5;
    private static final int HIGH_DICE = 10;
    private static final int ITERATION_BOUND = 51;

    private ProgressionGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            int progressionLength = RandomNumberUtils.getBoundedNumber(LOW_DICE, HIGH_DICE);
            int baseValue = RandomNumberUtils.getTwoDigitNumber();
            int iterationValue = RandomNumberUtils.getBoundedNumber(ITERATION_BOUND);
            int[] progression = generateProgression(progressionLength, baseValue, iterationValue);
            int hiddenNumberIndex = RandomNumberUtils.getBoundedNumber(progressionLength);
            gameRounds.putAll(generateRound(progression, hiddenNumberIndex));
        }
        Engine.start(gameRounds, RULES);
    }

    private static int[] generateProgression(int length, int baseValue, int iterationValue) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = baseValue + (iterationValue * i);
        }
        return progression;
    }

    private static Map<String, String> generateRound(int[] progression, int hiddenNumberIndex) {
        Map<String, String> round = new HashMap<>();
        StringBuilder question = new StringBuilder();
        String answer = "";
        for (int i = 0; i < progression.length; i++) {
            int number = progression[i];
            if (i == hiddenNumberIndex) {
                question.append("..");
                answer = String.valueOf(number);
            } else {
                question.append(number);
            }
            question.append(" ");
        }
        round.put(question.toString(), answer);
        return round;
    }
}
