package hexlet.code;

public class Greeting implements Game {

    private final String name;

    public Greeting() {
        name = "Greet";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void start(Player player) {
        System.out.println("Welcome to the Brain Games!");
        player.setName(Cli.readString("May I have your name? "));
        System.out.printf("Hello, %s!%s", player.getName(), System.lineSeparator());
    }
}
