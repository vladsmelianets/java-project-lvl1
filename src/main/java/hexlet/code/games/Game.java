package hexlet.code.games;

import hexlet.code.model.GameSession;

public interface Game {

    String getName();

    String getRules();

    GameSession getSession();
}
