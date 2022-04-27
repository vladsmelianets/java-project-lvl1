package hexlet.code.games;

import hexlet.code.model.GameSession;
import hexlet.code.utils.GameRandomizer;

public class EvenGame implements Game {

    private static final String YES = "yes";
    private static final String NO = "no";

    private final String name;
    private final String rules;

    public EvenGame() {
        this.name = "Even";
        this.rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
        int question = GameRandomizer.getInt();
        String answer = question % 2 == 0 ? YES : NO;
        return new GameSession(String.valueOf(question), answer);
    }
}
