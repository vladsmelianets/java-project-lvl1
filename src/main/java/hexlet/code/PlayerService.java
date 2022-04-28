package hexlet.code;

import hexlet.code.model.Player;
import hexlet.code.utils.Cli;

public final class PlayerService {

    public void greet(Player player) {
        System.out.println("Welcome to the Brain Games!");
        player.setName(Cli.readString("May I have your name? "));
        System.out.printf("Hello, %s!%s", player.getName(), System.lineSeparator());
    }
}
