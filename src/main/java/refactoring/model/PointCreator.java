package refactoring.model;

import refactoring.strategy.RandomStrategy;

public class PointCreator {

    private final Point point;

    public PointCreator(Point point) {
        this.point = point;
    }

    public Point generate(RandomStrategy randomStrategy) {
        if (point == null || !point.getStatus()) {
            return new Point(randomStrategy.hasPoint());
        }

        return new Point(false);
    }
}
