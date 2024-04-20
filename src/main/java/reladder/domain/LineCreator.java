package reladder.domain;

import reladder.strategy.RandomStrategy;

import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LineCreator {

    public Line run(Players players, RandomStrategy randomStrategy) {
        int playersCount = players.getCount();
        Point point = Point.createStart(randomStrategy.generate());

        Line line = Stream
                .iterate(point, prevPoint -> prevPoint.next(randomStrategy.generate()))
                .limit(playersCount)
                .collect(collectingAndThen(toList(), Line::new));

        line.lastLineEnded();
        return line;
    }
}
