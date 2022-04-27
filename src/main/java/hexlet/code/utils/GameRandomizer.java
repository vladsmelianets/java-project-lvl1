package hexlet.code.utils;

import java.util.Random;

public final class GameRandomizer {

    private static final Random RANDOM = new Random();

    private GameRandomizer() {
    }

    public static int getInt() {
        return RANDOM.nextInt();
    }
}
