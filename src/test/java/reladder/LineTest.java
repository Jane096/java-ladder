package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import reladder.domain.Line;
import reladder.domain.LineCreator;
import reladder.domain.Players;
import reladder.testStrategy.PointFalseStrategy;
import reladder.testStrategy.PointTrueStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0"}, delimiter = ':')
    @DisplayName("|-----| 로 그려진 사다리에서 0번째인 jane은 1번째로 이동하고 nana는 0번째로 이동한다.")
    void movePositionTest(int startPosition, int expectedPositionResult) {
        Players players = Players.of(List.of("jane", "nana"));

        Line line = new LineCreator().run(players, new PointTrueStrategy());
        int currentPositionAfterMove = line.move(startPosition);

        assertThat(currentPositionAfterMove).isEqualTo(expectedPositionResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1"}, delimiter = ':')
    @DisplayName("|     | 로 그려진 사다리에서 jane, nana 모두 이동하지 않는다.")
    void doNotMoveTest(int startPosition, int expectedPositionResult) {
        Players players = Players.of(List.of("jane", "nana"));

        Line line = new LineCreator().run(players, new PointFalseStrategy());
        int currentPositionAfterMove = line.move(startPosition);

        assertThat(currentPositionAfterMove).isEqualTo(expectedPositionResult);
    }
}
