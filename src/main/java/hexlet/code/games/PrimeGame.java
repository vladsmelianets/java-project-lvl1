package hexlet.code.games;

import hexlet.code.model.GameSession;

import java.util.Random;

public final class PrimeGame implements Game {

    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int TREE_DIGIT_BOUND = 1000;

    private final String name;
    private final String rules;
    private final Random random;

    public PrimeGame() {
        this.name = "Prime";
        this.rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
        int question = random.nextInt(TREE_DIGIT_BOUND);
        String answer = isPrime(question) ? YES : NO;
        return new GameSession(String.valueOf(question), answer);
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
