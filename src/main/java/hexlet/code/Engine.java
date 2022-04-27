package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.model.GameSession;
import hexlet.code.model.Player;
import hexlet.code.utils.Cli;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class Engine {

    private final Player player;
    private final int guessesToWin;

    public Engine(Player player, int guessesToWin) {
        this.player = player;
        this.guessesToWin = guessesToWin;
    }

    public void start(Game game) {
        out.println(game.getRules());
        int guesses = 0;
        while (guesses < guessesToWin) {
            GameSession session = game.getSession();
            out.println("Question: " + session.getQuestion());
            String playerAnswer = Cli.readString("Your answer: ");
            if (!playerAnswer.equals(session.getAnswer())) {
                out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%sLet's try again, %s!%s", playerAnswer,
                        session.getAnswer(), lineSeparator(), player.getName(), lineSeparator());
                return;
            }
            guesses++;
            out.println("Correct!");
        }
        out.printf("Congratulations, %s!%s", player.getName(), lineSeparator());
    }
}
