package hexlet.code.games;

import hexlet.code.model.GameSession;

import java.util.Random;

public final class EvenGame implements Game {

    private static final String YES = "yes";
    private static final String NO = "no";

    private final String name;
    private final String rules;
    private final Random random;

    public EvenGame() {
        this.name = "Even";
        this.rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
        int question = random.nextInt();
        String answer = question % 2 == 0 ? YES : NO;
        return new GameSession(String.valueOf(question), answer);
    }
}
