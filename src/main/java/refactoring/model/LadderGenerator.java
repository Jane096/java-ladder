package refactoring.model;

import refactoring.strategy.RandomStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGenerator {

    private final List<Line> lines;

    public LadderGenerator(List<Line> lines) {
        this.lines = lines;
    }

    public static LadderGenerator of(Height height, Players players, RandomStrategy randomStrategy) {
        List<Line> lines = Stream.generate(() -> new LineCreator(players.getCount()).create(randomStrategy))
                .limit(height.getHeight())
                .collect(Collectors.toList());

        return new LadderGenerator(lines);
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
