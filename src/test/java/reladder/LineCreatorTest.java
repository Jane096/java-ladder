package reladder;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.Line;
import reladder.domain.LineCreator;
import reladder.domain.Players;
import reladder.testStrategy.PointFalseStrategy;
import reladder.testStrategy.PointTrueStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineCreatorTest {

    @Test
    @DisplayName("플레이어 수가 2명이고 point가 true 일 경우 |-----| 모양으로 생성된다.")
    void createPointTrueTest() {
        Players players = Players.of(List.of("jane", "nana"));
        Line line = new LineCreator().run(players, new PointTrueStrategy());

        assertThat(line.toString()).isEqualTo("     |-----|");
    }

    @Test
    @DisplayName("플레이어 수가 3명이고 point가 false 일 경우 |     |     | 모양으로 생성된다.")
    void createPointFalseTest() {
        Players players = Players.of(List.of("jane", "nana", "john"));
        Line line = new LineCreator().run(players, new PointFalseStrategy());

        assertThat(line.toString()).isEqualTo("     |     |     |");
    }
}
