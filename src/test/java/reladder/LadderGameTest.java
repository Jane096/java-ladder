package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import reladder.domain.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    static Stream<Arguments> generateData() {
        return Stream.of(Arguments.of(
                Players.of(List.of("jane", "nana")), Height.of(5), Prizes.of(List.of("꽝", "당첨")), "꽝",
                Players.of(List.of("jane","nana","tom")), Height.of(3), Prizes.of(List.of("꽝", "당첨", "꽝")), "꽝",
                Players.of(List.of("jane","nana","tom","elin")), Height.of(7), Prizes.of(List.of("당첨", "당첨", "꽝","꽝")), "당첨"));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("사다리 게임 결과에서 존재하는 플레이어의 경우 매칭되는 상품 값이 있다.")
    void getPrizeValueByNameTest(Players players, Height height, Prizes prizes) {
        Ladder ladder = new LadderCreator().run(height, players);
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);

        String prize = ladderGame.getPrizeValueByName("jane");
        assertThat(prize).isNotEmpty();
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("사다리 게임에 없는 플레이어일 경우 예외가 발생한다.")
    void getPrizeValueByNameExceptionTest(Players players, Height height, Prizes prizes) {
        Ladder ladder = new LadderCreator().run(height, players);
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);

        assertThatThrownBy(() -> ladderGame.getPrizeValueByName("john"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어를 찾을 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("사다리 게임 결과에서 존재하는 플레이어의 경우 매칭되는 상품 값이 있다.")
    void getPrizeByCurrentPositionTest(Players players, Height height, Prizes prizes, String expectedPrizeValue) {
        Ladder ladder = new LadderCreator().run(height, players);
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);

        Prize prize = ladderGame.getPrizeByCurrentPosition(0);
        assertThat(prize.getValue()).isEqualTo(expectedPrizeValue);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("사다리 게임에 없는 플레이어일 경우 예외가 발생한다.")
    void getPrizeByCurrentPositionExceptionTest(Players players, Height height, Prizes prizes) {
        Ladder ladder = new LadderCreator().run(height, players);
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);

        assertThatThrownBy(() -> ladderGame.getPrizeByCurrentPosition(6))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("매칭되는 상품이 없습니다.");
    }
}
