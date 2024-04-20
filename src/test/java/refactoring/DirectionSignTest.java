package refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import reladder.domain.Direction;
import reladder.domain.DirectionSign;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static reladder.domain.DirectionSign.*;

public class DirectionSignTest {

    static Stream<Arguments> generateData() {
        return Stream.of(Arguments.of(
                Direction.of(true, false), LEFT,
                Direction.of(false, false), STAY,
                Direction.of(false, true), RIGHT));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("현재 생성 된 direction 값에 따라 왼쪽방향, 오른쪽방향, 정지 등의 값을 건네준다.")
    void getWayByDirectionTest(Direction direction, DirectionSign expectedDirectionSign) {
        int way = DirectionSign.getWayByDirection(direction);

        assertThat(way).isEqualTo(expectedDirectionSign.getWay());
    }

    @Test
    @DisplayName("현재 생성 된 direction 값이 DirectionSign에 없는 값일 경우 예외를 발생 시킨다.")
    void getWayByDirectionExceptionTest() {
        Direction invalidDirection = Direction.of(true, true);

        assertThatThrownBy(() -> DirectionSign.getWayByDirection(invalidDirection))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("해당하는 값이 없습니다.");
    }
}
