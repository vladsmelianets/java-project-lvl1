package hexlet.code.model;

public final class GameSession {

    private final String question;
    private final String answer;

    public GameSession(String sessionQuestion, String sessionAnswer) {
        this.question = sessionQuestion;
        this.answer = sessionAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
