package refactoring.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int move(Direction direction) {
        if (Point.isLeftLadderHasPoint(points, direction)) {
            return direction.goLeft();
        }

        if (Point.isNoPoint(points, direction)) {
            return direction.stay();
        }

        if (Point.isRightLadderHasPoint(points, direction)) {
            return direction.goRight();
        }

        return direction.getPosition();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(this.points);
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }
}
