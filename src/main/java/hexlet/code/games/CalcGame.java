package hexlet.code.games;

import hexlet.code.model.GameSession;

import java.util.Random;

public final class CalcGame implements Game {

    private static final int TWO_DIGIT_BOUND = 100;
    private static final int OPERATOR_DICE_BOUND = 3;

    private final String name;
    private final String rules;
    private final Random random;

    public CalcGame() {
        this.name = "Calc";
        this.rules = "What is the result of the expression?";
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
        int firstNumber = random.nextInt(TWO_DIGIT_BOUND);
        int secondNumber = random.nextInt(TWO_DIGIT_BOUND);
        int operatorDice = random.nextInt(OPERATOR_DICE_BOUND);

        if (operatorDice == 1) {
            return new GameSession(buildQuestion(firstNumber, secondNumber, '-'),
                    String.valueOf(firstNumber - secondNumber));
        }
        if (operatorDice == 2) {
            return new GameSession(buildQuestion(firstNumber, secondNumber, '*'),
                    String.valueOf(firstNumber * secondNumber));
        }
        return new GameSession(buildQuestion(firstNumber, secondNumber, '+'),
                String.valueOf(firstNumber + secondNumber));
    }

    private String buildQuestion(int firstNumber, int secondNumber, char operator) {
        return firstNumber + " " + operator + " " + secondNumber;
    }
}
