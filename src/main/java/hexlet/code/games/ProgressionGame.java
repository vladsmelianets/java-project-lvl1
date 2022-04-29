package hexlet.code.games;

import hexlet.code.model.GameSession;

import java.util.Random;

public final class ProgressionGame implements Game {

    private static final int LOW_DICE = 4;
    private static final int HIGH_DICE = 10;
    private static final int TWO_DIGIT_BOUND = 100;

    private final String name;
    private final String rules;
    private final Random random;

    public ProgressionGame() {
        this.name = "Progression";
        this.rules = "What number is missing in the progression?";
        this.random = new Random();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRules() {
        return rules;
    }

    @Override
    public GameSession getSession() {
        int progressionLength = random.nextInt(LOW_DICE, HIGH_DICE);
        int hiddenNumberIndex = random.nextInt(progressionLength + 1);
        int baseValue = random.nextInt(TWO_DIGIT_BOUND);
        int iterationValue = random.nextInt(LOW_DICE + 1, HIGH_DICE + 1);

        StringBuilder question = new StringBuilder(baseValue);
        String answer = "";
        for (int i = 0; i <= progressionLength; i++) {
            int number = baseValue + (iterationValue * i);
            if (i == hiddenNumberIndex) {
                question.append("..");
                answer = String.valueOf(number);
            } else {
                question.append(number);
            }
            question.append(" ");
        }
        return new GameSession(question.toString(), answer);
    }
}
