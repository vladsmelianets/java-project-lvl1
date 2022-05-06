package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.model.GameSession;
import hexlet.code.utils.CliHelper;

import java.util.Scanner;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public final class Engine {

    public static final int GUESSES_TO_WIN = 3;

    public void start(Game game) {
        out.println(game.getRules());

        System.out.println(System.lineSeparator() + "Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String userName = new Scanner(System.in).nextLine();
        System.out.println("Hello, " + userName + "!");

        int guesses = 0;
        while (guesses < GUESSES_TO_WIN) {
            GameSession session = game.getSession();
            out.println("Question: " + session.getQuestion());
            String playerAnswer = CliHelper.readString("Your answer: ");
            if (!playerAnswer.equals(session.getAnswer())) {
                out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%sLet's try again, %s!%s", playerAnswer,
                        session.getAnswer(), lineSeparator(), userName, lineSeparator());
                return;
            }
            guesses++;
            out.println("Correct!");
        }
        out.printf("Congratulations, %s!%s", userName, lineSeparator());
    }
}
