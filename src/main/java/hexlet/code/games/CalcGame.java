package hexlet.code.games;

import hexlet.code.model.GameSession;
import hexlet.code.utils.GameRandomizer;

public final class CalcGame implements Game {

    private final String name;
    private final String rules;

    public CalcGame() {
        this.name = "Calc";
        this.rules = "What is the result of the expression?";
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
        int firstNumber = GameRandomizer.getTwoDigitPositiveInt();
        int secondNumber = GameRandomizer.getTwoDigitPositiveInt();
        char operator = GameRandomizer.getOperator();

        if (operator == '+') {
            return new GameSession(buildQuestion(firstNumber, secondNumber, operator),
                    String.valueOf(firstNumber + secondNumber));
        }
        if (operator == '-') {
            return new GameSession(buildQuestion(firstNumber, secondNumber, operator),
                    String.valueOf(firstNumber - secondNumber));
        }
        if (operator == '*') {
            return new GameSession(buildQuestion(firstNumber, secondNumber, operator),
                    String.valueOf(firstNumber * secondNumber));
        }
        return null;
    }

    private String buildQuestion(int firstNumber, int secondNumber, char operator) {
        return firstNumber + " " + operator + " " + secondNumber;
    }
}
