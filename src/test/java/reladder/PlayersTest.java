package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import reladder.domain.Players;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(
                        List.of("jane","nana","john"), "jane",
                        List.of("nana","jane"), "nana",
                        List.of("elin","nana","john","jane"), "elin",
                        List.of("tom","nana","john","elin","jane"), "tom"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("플레이어 이름을 리스트로 넘기면, 리스트에 넘긴 이름 수 만큼 플레이어를 생성한다.")
    void createPlayersTest(List<String> names, String expectedPlayerName) {
        Players players = Players.of(names);
        assertThat(players.getPlayers().get(0).isPlayerNameExist(expectedPlayerName)).isTrue();
    }

    @Test
    @DisplayName("플레이어 이름 중에서 5글자가 넘는 경우가 있다면 예외가 발생한다.")
    void createPlayersFalseTest() {
        assertThatThrownBy(() -> Players.of(List.of("hahahahah","john")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 넘길 수 없습니다.");
    }

    @Test
    @DisplayName("플레이어 이름 중에서 빈 값이 있다면 예외가 발생한다.")
    void createPlayersEmptyNameTest() {
        assertThatThrownBy(() -> Players.of(List.of("","john")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 없습니다.");
    }
}
