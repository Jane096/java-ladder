package reladder.domain;

import reladder.strategy.PointRandomStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderCreator {

    public Ladder run(Height height, Players players) {
        List<Line> lines = Stream.generate(() -> new LineCreator().run(players, new PointRandomStrategy()))
                .limit(height.getHeight())
                .collect(Collectors.toList());

        return new Ladder(lines);
    }
}
