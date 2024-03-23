package refactoring.model;

import java.util.List;

public class Point {

    private final boolean status;

    public Point(boolean status) {
        this.status = status;
    }

    public Point() {
        this(false);
    }

    public boolean getStatus() {
        return this.status;
    }

    public static boolean isNoPoint(List<Point> points, Direction direction) {
        return direction.getPosition() == points.size() && !hasPoint(points, direction.getPrevious());
    }

    public static boolean isLeftLadderHasPoint(List<Point> points, Direction direction) {
        return direction.getPosition() > 0 && hasPoint(points, direction.getPrevious());
    }

    public static boolean isRightLadderHasPoint(List<Point> points, Direction direction) {
        return direction.getPosition() < points.size() && hasPoint(points, direction.getPosition());
    }

    public static boolean hasPoint(List<Point> points, int location) {
        return points.get(location).getStatus();
    }


    @Override
    public String toString() {
        if (this.status) {
            return Ladder.LINE_WITH_POINTS.getShape();
        }

        return Ladder.LINE_ONLY.getShape();
    }
}
