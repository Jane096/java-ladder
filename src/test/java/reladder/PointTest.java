package reladder;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import reladder.domain.Point;
import reladder.testStrategy.PointFalseStrategy;
import reladder.testStrategy.PointTrueStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false, true})
    @DisplayName("사다리 라인 시작지점의 포인트는 왼쪽은 항상 false, 오른쪽은 랜덤으로 받은 인자 값을 보고 생성한다.")
    void createStartPointTest(boolean value) {
        Point point = Point.createStart(value);

        assertAll(
                () -> assertFalse(point.getDirection().getLeft()),
                () -> assertEquals(0, point.getPosition()),
                () -> assertEquals(value, point.getDirection().getRight())
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true:false", "false:false:true"}, delimiter = ':')
    @DisplayName("시작포인트가 생성되고 다음 포인트 생성 시, 시작포인트의 오른쪽 방향 값이 false일 경우 pointTrueStrategy 값을 넣는다.")
    void createNextPointWithTrueStrategy(boolean startRightValue, boolean expectedLeft, boolean expectedRightValue) {
        Point point = Point.createStart(startRightValue);
        Point nextPoint = point.next(new PointTrueStrategy().generate());

        assertAll(
                () -> assertEquals(expectedLeft, nextPoint.getDirection().getLeft()),
                () -> assertEquals(expectedRightValue, nextPoint.getDirection().getRight())
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"true:true:false", "false:false:false"}, delimiter = ':')
    @DisplayName("시작포인트가 생성되고 다음 포인트 생성 시, 시작포인트의 오른쪽 방향 값이 false일 경우 pointFalseStrategy 값을 넣는다.")
    void createNextPointWithFalseStrategy(boolean startRightValue, boolean expectedLeft, boolean expectedRightValue) {
        Point point = Point.createStart(startRightValue);
        Point nextPoint = point.next(new PointFalseStrategy().generate());

        assertAll(
                () -> assertEquals(expectedLeft, nextPoint.getDirection().getLeft()),
                () -> assertEquals(expectedRightValue, nextPoint.getDirection().getRight())
        );
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("포인트 생성 시 마지막 부분은 항상 false를 가져야 한다.")
    void createEndPointTest(boolean startRightValue) {
        Point point = Point.createStart(startRightValue);
        point.end();

        assertThat(point.getDirection().getRight()).isFalse();
    }
}
