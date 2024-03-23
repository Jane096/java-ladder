package refactoring.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResult {

    private final Map<Player, Prize> results;

    public LadderResult(Map<Player, Prize> results) {
        this.results = results;
    }

    public static LadderResult of(Players players, List<Prize> prizes, List<Line> lines) {
        Map<Player, Prize> results = new LinkedHashMap<>();
        IntStream.range(0, players.getCount())
                .forEach(index -> results.put(players.getPlayers().get(index), prizes.get(new Director(lines).move(index))));

        return new LadderResult(results);
    }

    public Map<Player, Prize> getResults() {
        return this.results;
    }
}
