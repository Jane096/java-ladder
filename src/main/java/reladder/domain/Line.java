package reladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int move(int currentPosition) {
        Point currentPoint = this.points.get(currentPosition);

        int way = DirectionSign.getWayByDirection(currentPoint.getDirection());
        return currentPosition + way;
    }

    public void lastLineEnded() {
        int lastIndex = this.points.size() - 1;
        this.points.get(lastIndex).end();
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }
}
