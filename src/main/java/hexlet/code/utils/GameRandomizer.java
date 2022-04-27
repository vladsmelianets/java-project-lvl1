package hexlet.code.utils;

import java.util.Random;

public final class GameRandomizer {

    private static final Random RANDOM = new Random();

    private static final int TWO_DIGITS_BOUND = 100;
    private static final int NUMBER_OF_OPERATORS = 3;

    private GameRandomizer() {
    }

    public static int getInt() {
        return RANDOM.nextInt();
    }

    public static int getTwoDigitPositiveInt() {
        return RANDOM.nextInt(TWO_DIGITS_BOUND);
    }

    public static char getOperator() {
        int operatorDice = RANDOM.nextInt(NUMBER_OF_OPERATORS);
        char operator = '+';
        if (operatorDice == 1) {
            operator = '-';
        }
        if (operatorDice == 2) {
            operator = '*';
        }
        return operator;
    }
}
