package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class ProgressionGame {

    private static final String RULES = "What number is missing in the progression?";
    private static final int NUMBER_OF_ROUNDS = 3;

    private static final Random RANDOM = new Random();
    private static final int LOW_DICE = 4;
    private static final int HIGH_DICE = 10;
    private static final int TWO_DIGIT_BOUND = 100;

    private ProgressionGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = generateGameRounds();
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateGameRounds() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            int progressionLength = RANDOM.nextInt(LOW_DICE, HIGH_DICE);
            int hiddenNumberIndex = RANDOM.nextInt(progressionLength + 1);
            int baseValue = RANDOM.nextInt(TWO_DIGIT_BOUND);
            int iterationValue = RANDOM.nextInt(LOW_DICE + 1, HIGH_DICE + 1);

            StringBuilder question = new StringBuilder(baseValue);
            String answer = "";
            for (int j = 0; j <= progressionLength; j++) {
                int number = baseValue + (iterationValue * j);
                if (j == hiddenNumberIndex) {
                    question.append("..");
                    answer = String.valueOf(number);
                } else {
                    question.append(number);
                }
                question.append(" ");
            }
            gameRounds.put(question.toString(), answer);
        }
        return gameRounds;
    }
}
