package reladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Players {

    private final List<Player> players;
    private static final int START = 0;

    private Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    public static Players of(List<String> names) {
        List<Player> results = new ArrayList<>();
        IntStream.range(START, names.size())
                .forEach(position -> results.add(new Player(names.get(position), position)));

        return new Players(results);
    }

    public int getPlayerPosition(String name) {
        return players.stream()
                .filter(player -> player.isPlayerNameExist(name))
                .map(Player::getPosition)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("플레이어를 찾을 수 없습니다."));
    }


    public int getCount() {
        return this.players.size();
    }
}
