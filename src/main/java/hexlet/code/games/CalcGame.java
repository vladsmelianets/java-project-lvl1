package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomNumberUtils;

import java.util.HashMap;
import java.util.Map;

public final class CalcGame {

    private static final String RULES = "What is the result of the expression?";
    private static final int OPERATOR_DICE_BOUND = 3;
    private static final char[] OPERATORS = {'+', '-', '*'};

    private CalcGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            int firstNumber = RandomNumberUtils.getTwoDigitNumber();
            int secondNumber = RandomNumberUtils.getTwoDigitNumber();
            int dice = RandomNumberUtils.getBoundedNumber(OPERATOR_DICE_BOUND);
            gameRounds.putAll(generateRound(firstNumber, secondNumber, OPERATORS[dice]));
        }
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateRound(int firstNumber, int secondNumber, char operator) {
        Map<String, String> round = new HashMap<>();
        String question;
        String answer;
        switch (operator) {
            case '+':
                question = firstNumber + " " + '+' + " " + secondNumber;
                answer = String.valueOf(firstNumber + secondNumber);
                break;
            case '-':
                question = firstNumber + " " + operator + " " + secondNumber;
                answer = String.valueOf(firstNumber - secondNumber);
                break;
            case '*':
                question = firstNumber + " " + operator + " " + secondNumber;
                answer = String.valueOf(firstNumber * secondNumber);
                break;
            default:
                throw new Error("Unknown operator: " + operator);
        }
        round.put(question, answer);
        return round;
    }
}
