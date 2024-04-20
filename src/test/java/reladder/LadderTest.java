package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import reladder.domain.Height;
import reladder.domain.Ladder;
import reladder.domain.Line;
import reladder.domain.LineCreator;
import reladder.domain.Players;
import reladder.testStrategy.PointFalseStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    static Stream<Arguments> generateData() {
        return Stream.of(Arguments.of(
                Players.of(List.of("jane","nana")), 5, "jane",
                Players.of(List.of("jane","nana","tom")), 3, "nana",
                Players.of(List.of("jane","nana","tom","elin")), 7, "elin"));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("사다리타기에서 아무 포인트 없이 만들어졌을 때 플레이어의 현재 위치와 동일하다.")
    void moveTest(Players players, int heightInput, String testPlayer) {
        Height height = Height.of(heightInput);
        List<Line> lines = Stream.generate(() -> new LineCreator().run(players, new PointFalseStrategy()))
                .limit(height.getHeight())
                .collect(Collectors.toList());

        Ladder ladder = new Ladder(lines);

        int currentPosition = players.getPlayerPosition(testPlayer);
        int moved = ladder.move(currentPosition);

        assertThat(currentPosition).isEqualTo(moved);
    }
}
