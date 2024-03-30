package reladder.domain;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeftHasPoint() {
        return this.left && !this.right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction start(boolean right) {
        return Direction.of(false, right);
    }

    public Direction next(boolean left) {
        if (this.right) {
            return Direction.of(true, false);
        }

        return Direction.of(false, left);
    }

    public Direction last() {
        return Direction.of(this.right, false);
    }

    public void end() {
        this.right = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
