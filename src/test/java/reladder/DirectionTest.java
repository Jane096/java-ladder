package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import reladder.domain.Direction;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false, true, true})
    @DisplayName("사다리 시작 지점의 방향은 왼쪽은 항상 false, 오른쪽은 랜덤 값이 들어간다.")
    void startDirectionTest(boolean right) {
        Direction direction = Direction.start(right);

        assertThat(direction.getRight()).isEqualTo(right);
        assertThat(direction.getLeft()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false, true, true})
    @DisplayName("오른쪽에 포인트가 있는 경우 인자로 넘겨준 왼쪽 값과 상관없이 왼쪽 방향은 true, 오른쪽은 false가 출력된다.")
    void nextDirectionRightIsTrueTest(boolean left) {
        Direction direction = Direction.of(false, true);
        Direction leftHasDirection = direction.next(left);

        assertThat(leftHasDirection.getLeft()).isTrue();
        assertThat(leftHasDirection.getRight()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false, true, true, false, false})
    @DisplayName("오른쪽에 포인트가 없는 경우 왼쪽은 항상 false이며, 오른쪽 값은 인자로 넘겨준 왼쪽 값에 따라 달라진다.")
    void nextDirectionRightIsFalseTest(boolean left) {
        Direction direction = Direction.of(true, false);
        Direction leftHasDirection = direction.next(left);

        assertThat(leftHasDirection.getLeft()).isFalse();
        assertThat(leftHasDirection.getRight()).isEqualTo(left);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false, true, true, false, false})
    @DisplayName("사다리 종료 지점은 현재 방향에 상관없이 오른쪽은 항상 false이다.")
    void endDirectionTest(boolean right) {
        Direction direction1 = Direction.of(true, right);
        Direction direction2 = Direction.of(false, right);

        direction1.end();
        direction2.end();

        assertThat(direction1.getRight()).isFalse();
        assertThat(direction2.getRight()).isFalse();
    }
}
