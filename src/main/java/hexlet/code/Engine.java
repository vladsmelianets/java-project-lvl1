package hexlet.code;

import java.util.Map;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public final class Engine {

    private Engine() {
    }

    public static void start(Map<String, String> gameRounds, String rules) {
        out.println(rules);
        out.println(System.lineSeparator() + "Welcome to the Brain Games!");
        out.print("May I have your name? ");
        String userName = UserInput.getString();
        out.println("Hello, " + userName + "!");

        boolean isWon = playRounds(gameRounds, userName);
        if (isWon) {
            out.printf("Congratulations, %s!%s", userName, lineSeparator());
        }
    }

    private static boolean playRounds(Map<String, String> gameRounds, String userName) {
        for (Map.Entry<String, String> round : gameRounds.entrySet()) {
            out.println("Question: " + round.getKey());
            out.print("Your answer: ");
            String userAnswer = UserInput.getString();
            if (!userAnswer.equals(round.getValue())) {
                out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%sLet's try again, %s!%s", userAnswer,
                        round.getValue(), lineSeparator(), userName, lineSeparator());
                return false;
            } else {
                out.println("Correct!");
            }
        }
        return true;
    }
}
