package reladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {

    private final LadderGame ladderGame;

    public GameResult(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public Map<String, String> generateResults() {
        Map<String, String> results = new LinkedHashMap<>();

        this.ladderGame.getPlayers()
                .forEach(player -> results.put(player.getName(), ladderGame.getPrizeValueByName(player.getName())));

        return results;
    }
}
