package refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import refactoring.model.Direction;
import refactoring.model.Line;
import refactoring.model.LineCreator;
import refactoring.testStrategy.PointTrueStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {0})
    @DisplayName("시작점 0에서 사다리 가로포인트가 그려져있다면 위치를 1칸 이동한다.")
    void moveTest(int startPosition) {
        Line line = new LineCreator(3).create(new PointTrueStrategy());
        int position = line.move(new Direction(startPosition));
        assertThat(position).isEqualTo(1);
    }
}
