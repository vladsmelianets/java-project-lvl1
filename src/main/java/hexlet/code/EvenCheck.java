package hexlet.code;

import java.util.Random;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class EvenCheck implements Game {

    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int GUESSES_TO_WIN = 3;

    private final String name;
    private final Random rnd;
    private int guesses;

    public EvenCheck() {
        this.name = "Even";
        guesses = 0;
        rnd = new Random();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void start(String playerName) {
        out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (guesses < GUESSES_TO_WIN) {
            int number = rnd.nextInt();
            out.println("Question: " + number);
            String answer = Cli.readString("Your answer: ");

            String correctAnswer = number % 2 == 0 ? YES : NO;
            if (answer.equals(correctAnswer)) {
                guesses++;
                out.println("Correct!");
            } else {
                out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%sLet's try again, %s!%s", answer,
                        correctAnswer, lineSeparator(), playerName, lineSeparator());
            }
        }

        out.printf("Congratulations, %s!%s", playerName, lineSeparator());
    }
}
