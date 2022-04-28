package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.model.GameSession;
import hexlet.code.utils.Cli;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public final class Engine {

    private final String playerName;
    public static final int GUESSES_TO_WIN = 3;

    public Engine(String playerName) {
        this.playerName = playerName;
    }

    public void start(Game game) {
        out.println(game.getRules());
        int guesses = 0;
        while (guesses < GUESSES_TO_WIN) {
            GameSession session = game.getSession();
            out.println("Question: " + session.getQuestion());
            String playerAnswer = Cli.readString("Your answer: ");
            if (!playerAnswer.equals(session.getAnswer())) {
                out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%sLet's try again, %s!%s", playerAnswer,
                        session.getAnswer(), lineSeparator(), playerName, lineSeparator());
                return;
            }
            guesses++;
            out.println("Correct!");
        }
        out.printf("Congratulations, %s!%s", playerName, lineSeparator());
    }
}
