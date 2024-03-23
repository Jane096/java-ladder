package refactoring.model;

import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    public int getCount() {
        return this.players.size();
    }
}
