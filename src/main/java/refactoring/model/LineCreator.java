package refactoring.model;

import refactoring.strategy.RandomStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LineCreator {

    private final int playersCount;

    public LineCreator(int playersCount) {
        this.playersCount = playersCount;
    }

    public Line create(RandomStrategy randomStrategy) {
        List<Point> result = new ArrayList<>();
        IntStream.range(0, playersCount - 1)
                .forEach(count ->
                        result.add(new PointCreator(isPreviousPointExist(result, count)).generate(randomStrategy)));

        return new Line(result);
    }

    public Point isPreviousPointExist(List<Point> points, int playerCountIndex) {
        if (playerCountIndex == 0 || points.isEmpty()) {
            return new Point();
        }

        return points.get(playerCountIndex - 1);
    }
}
