package refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import refactoring.model.*;
import refactoring.testStrategy.PointFalseStrategy;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(LadderGenerator.of(new Height(5), new Players(List.of(new Player("jane"), new Player("haha"))), new PointFalseStrategy()),
                        new Players(List.of(new Player("jane"), new Player("nana"))),
                        List.of(new Prize("no"), new Prize("yes")))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("포인트가 없는 사다리가 있을 때 jane의 상품은 no, nana는 yes가 나온다.")
    void allLadderResultTest(LadderGenerator ladderGenerator, Players players, List<Prize> prizes) {
        LadderResult ladderResult = LadderResult.of(players, prizes, ladderGenerator.getLines());
        assertThat(ladderResult.getResults().get(players.getPlayers().get(0)).getValue()).isEqualTo("no");
        assertThat(ladderResult.getResults().get(players.getPlayers().get(1)).getValue()).isEqualTo("yes");
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("포인트가 없는 사다리가 있을 때 jane의 결과만 알고 싶을 때 no가 출력된다.")
    void particularPlayerPrize(LadderGenerator ladderGenerator, Players players, List<Prize> prizes) {
        LadderResult ladderResult = LadderResult.of(players, prizes, ladderGenerator.getLines());
        assertThat(ladderResult.getResults().get(players.getPlayers().get(0)).getValue()).isEqualTo("no");
    }
}
