package refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import refactoring.model.Height;
import refactoring.model.LadderGenerator;
import refactoring.model.Player;
import refactoring.model.Players;
import refactoring.strategy.PointRandomStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderCreatorTest {

    @ParameterizedTest
    @CsvSource(value = {"5:2", "4:3", "7:3", "8:4"}, delimiter = ':')
    @DisplayName("라인 수 만큼 세로 | 라인을 만든다.")
    void ladderGameStartTest(int lineHeight, int playerCount) {
        List<Player> players = new ArrayList<>(playerCount);
        LadderGenerator ladder = LadderGenerator.of(new Height(lineHeight), new Players(players), new PointRandomStrategy());
        assertThat(ladder.getLines().size()).isEqualTo(lineHeight);
    }
}
