package hexlet.code.games;

import hexlet.code.model.GameSession;
import hexlet.code.utils.GameRandomizer;

public final class GcdGame implements Game {

    private final String name;
    private final String rules;

    public GcdGame() {
        this.name = "GCD";
        this.rules = "Find the greatest common divisor of given numbers.";
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
        int firstNum = GameRandomizer.getTwoDigitPositiveInt();
        int secondNum = GameRandomizer.getTwoDigitPositiveInt();
        String question = firstNum + " " + secondNum;
        String answer = String.valueOf(calcGcd(firstNum, secondNum));
        return new GameSession(question, answer);
    }

    private int calcGcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return calcGcd(second, first % second);
    }
}
