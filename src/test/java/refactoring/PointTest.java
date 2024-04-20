package refactoring;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactoring.model.Direction;
import refactoring.model.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    @DisplayName("사다리에 가로 포인트가 없는 경우 isNoPoint 호출 시 true가 나온다.")
    void isNoPointTest() {
        List<Point> points = List.of(new Point(false));
        boolean result = Point.isNoPoint(points, new Direction(1));
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("사다리에 가로 포인트가 있는 경우 isNoPoint 호출 시 false가 나온다.")
    void isNoPointFalseTest() {
        List<Point> points = List.of(new Point(true));
        boolean result = Point.isNoPoint(points, new Direction(1));
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("현재 출발 위치에서 오른쪽에 가로포인트가 있는 경우 true를 반환한다.")
    void isRightLadderHasPointTrueTest() {
        List<Point> points = List.of(new Point(true), new Point(false));
        boolean result = Point.isRightLadderHasPoint(points, new Direction(0));
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("현재 출발 위치에서 오른쪽에 가로포인트가 없는 경우 false를 반환한다.")
    void isRightLadderHasPointFalseTest() {
        List<Point> points = List.of(new Point(false), new Point(true));
        boolean result = Point.isRightLadderHasPoint(points, new Direction(0));
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("현재 위치에서 왼쪽에 가로포인트가 있는 경우 true를 반환한다.")
    void isLeftLadderHasPointTrueTest() {
        List<Point> points = List.of(new Point(false), new Point(true));
        boolean result = Point.isRightLadderHasPoint(points, new Direction(1));
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("현재 위치에서 왼쪽에 가로포인트가 없는 경우 false를 반환한다.")
    void isLeftLadderHasPointFalseTest() {
        List<Point> points = List.of(new Point(true), new Point(false));
        boolean result = Point.isRightLadderHasPoint(points, new Direction(1));
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("point가 있는지 여부를 알고 싶을 때 현재 위치 값을 넣으면 결과를 반환한다.")
    void hasPointTest() {
        List<Point> points = List.of(new Point(true), new Point(false), new Point(true));

        assertAll(
                () -> assertTrue(Point.hasPoint(points, 0)),
                () -> assertFalse(Point.hasPoint(points, 1)),
                () -> assertTrue(Point.hasPoint(points, 2))
        );
    }
}
