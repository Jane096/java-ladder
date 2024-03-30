package reladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public enum DirectionSign {

    LEFT(Direction.of(true, false), -1),
    STAY(Direction.of(false, false), 0),
    RIGHT(Direction.of(false, true), 1)
    ;

    private final Direction direction;
    private final int way;

    private DirectionSign(Direction direction, int way) {
        this.direction = direction;
        this.way = way;
    }

    private static final List<DirectionSign> ALL_SIGNS = Arrays.asList(DirectionSign.values());

    public static int getWayByDirection(Direction direction) {
        return ALL_SIGNS.stream()
                .filter(directionSign -> direction.equals(directionSign.getDirection()))
                .map(DirectionSign::getWay)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("해당하는 값이 없습니다."));
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getWay() {
        return this.way;
    }
}
