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

    public EvenCheck() {
        this.name = "Even";
        rnd = new Random();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void start(Player player) {
        out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int guesses = 0;
        while (guesses < GUESSES_TO_WIN) {
            int number = rnd.nextInt();
            out.println("Question: " + number);
            String answer = Cli.readString("Your answer: ");

            String correctAnswer = getCorrectAnswer(number);
            if (answer.equals(correctAnswer)) {
                guesses++;
                out.println("Correct!");
            } else {
                out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%sLet's try again, %s!%s", answer,
                        correctAnswer, lineSeparator(), player.getName(), lineSeparator());
                break;
            }
        }
        if (guesses >= GUESSES_TO_WIN) {
            out.printf("Congratulations, %s!%s", player.getName(), lineSeparator());
        }
    }

    private String getCorrectAnswer(int number) {
        return number % 2 == 0 ? YES : NO;
    }
}
