package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import reladder.domain.Height;
import reladder.domain.Ladder;
import reladder.domain.LadderCreator;
import reladder.domain.Players;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderCreatorTest {

    static Stream<Arguments> generateData() {
        return Stream.of(Arguments.of(
                Players.of(List.of("jane","nana")), 5,
                Players.of(List.of("jane","nana","tom")), 3,
                Players.of(List.of("jane","nana","tom","elin")), 7));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("사다리의 포인트는 플레이어 수 만큼 생성된다.")
    void createTest(Players players, int heightInput) {
        Height height = Height.of(heightInput);
        Ladder ladder = new LadderCreator().run(height, players);

        assertThat(ladder.getLines().size()).isEqualTo(heightInput);
        assertThat(ladder.getLines().get(0).getPoints().size()).isEqualTo(players.getCount());
    }
}
