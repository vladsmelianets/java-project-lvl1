package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class CalcGame {

    private static final String RULES = "What is the result of the expression?";
    private static final int NUMBER_OF_ROUNDS = 3;

    private static final Random RANDOM = new Random();
    private static final int TWO_DIGIT_BOUND = 100;
    private static final int OPERATOR_DICE_BOUND = 3;

    private static final char[] operators = {'+', '-', '*'};

    private CalcGame() {
    }

    public static void play() {
        Map<String, String> gameRounds = generateGameRounds();
        Engine.start(gameRounds, RULES);
    }

    private static Map<String, String> generateGameRounds() {
        Map<String, String> gameRounds = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            int firstNumber = RANDOM.nextInt(TWO_DIGIT_BOUND);
            int secondNumber = RANDOM.nextInt(TWO_DIGIT_BOUND);
            int operatorDice = RANDOM.nextInt(OPERATOR_DICE_BOUND);

            String question;
            String answer;
            char operator = operators[operatorDice];
            switch (operator) {
                case '-':
                    question = concatQuestion(firstNumber, secondNumber, operator);
                    answer = String.valueOf(firstNumber - secondNumber);
                    break;
                case '*':
                    question = concatQuestion(firstNumber, secondNumber, operator);
                    answer = String.valueOf(firstNumber * secondNumber);
                    break;
                default:
                    question = concatQuestion(firstNumber, secondNumber, '+');
                    answer = String.valueOf(firstNumber + secondNumber);
            }
            gameRounds.put(question, answer);
        }
        return gameRounds;
    }

    private static String concatQuestion(int firstNumber, int secondNumber, char operator) {
        return firstNumber + " " + operator + " " + secondNumber;
    }
}
