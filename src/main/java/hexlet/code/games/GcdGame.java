package hexlet.code.games;

import hexlet.code.model.GameSession;

import java.util.Random;

public final class GcdGame implements Game {

    private static final int TWO_DIGIT_BOUND = 100;

    private final String name;
    private final String rules;
    private final Random random;

    public GcdGame() {
        this.name = "GCD";
        this.rules = "Find the greatest common divisor of given numbers.";
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
        int firstNum = random.nextInt(TWO_DIGIT_BOUND);
        int secondNum = random.nextInt(TWO_DIGIT_BOUND);
        String question = firstNum + " " + secondNum;
        String answer = String.valueOf(calcGcd(firstNum, secondNum));
        return new GameSession(question, answer);
    }

    private int calcGcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return calcGcd(second, first % second);
    }
}
