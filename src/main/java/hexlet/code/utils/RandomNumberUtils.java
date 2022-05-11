package hexlet.code.utils;

import java.util.Random;

public final class RandomNumberUtils {

    private RandomNumberUtils() {
    }

    private static final Random RANDOM = new Random();
    private static final int TWO_DIGIT_BOUND = 100;
    private static final int THREE_DIGIT_BOUND = 1000;

    public static int getTwoDigitNumber() {
        return RANDOM.nextInt(TWO_DIGIT_BOUND);
    }

    public static int getThreeDigitNumber() {
        return RANDOM.nextInt(THREE_DIGIT_BOUND);
    }

    public static int getBoundedNumber(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int getBoundedNumber(int lowBound, int highBound) {
        return RANDOM.nextInt(lowBound, highBound);
    }

    public static int getNumber() {
        return RANDOM.nextInt();
    }
}
