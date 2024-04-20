package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    @DisplayName("사다리 게임을 진행한 후, 결과 도출 시 플레이어별로 prize가 매칭된다.")
    void generateResultsTest() {
        Players players = Players.of(List.of("jane", "nana"));
        Height height = Height.of(5);
        Prizes prizes = Prizes.of(List.of("꽝", "당첨"));

        Ladder ladder = new LadderCreator().run(height, players);
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);

        GameResult gameResult = new GameResult(ladderGame);
        Map<String, String> results = gameResult.generateResults();

        assertThat(results.get("jane")).isNotEmpty();
        assertThat(results.get("nana")).isNotEmpty();
    }
}
