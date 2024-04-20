package reladder.domain;

public class Point {

    private final int position;
    private final Direction direction;
    private static final int START = 0;

    public Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }


    public static Point createStart(boolean value) {
        return new Point(START, Direction.start(value));
    }

    public Point next(boolean value) {
        return new Point(this.position, direction.next(value));
    }

    public void end() {
        this.direction.end();
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        if (this.direction.isLeftHasPoint()) {
            return LadderShape.LINE_WITH_POINTS.getShape();
        }

        return LadderShape.LINE_ONLY.getShape();
    }
}
