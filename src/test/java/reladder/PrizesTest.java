package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import reladder.domain.Prize;
import reladder.domain.Prizes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizesTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(
                        List.of("꽝","당첨","당첨"), 0, "꽝",
                        List.of("1","2","3"), 2, "",
                        List.of("발표","없음","없음","없음"), 1, "없음",
                        List.of("o","x","o","x","o"), 3, "x"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("입력된 상품 리스트 만큼 값을 생성하고, 입력한 순서대로 생성한다.")
    void createPrizesTest(List<String> prizeNames, int testIndex, String expectedResult) {
        Prizes prizes = Prizes.of(prizeNames);
        assertThat(prizes.getPrizes().get(testIndex).getValue()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void getPrizeByCurrentPositionTest(List<String> prizeNames, int testIndex, String expectedResult) {
        Prizes prizes = Prizes.of(prizeNames);
        Prize currentPrize = prizes.getPrizeByCurrentPosition(testIndex);

        assertThat(currentPrize.getValue()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("현재 존재하지 않는 상품 위치를 통해 조회할 경우 예외가 발생한다.")
    void getPrizeByCurrentPositionTest(List<String> prizeNames) {
        Prizes prizes = Prizes.of(prizeNames);

        assertThatThrownBy(() -> prizes.getPrizeByCurrentPosition(5))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("매칭되는 상품이 없습니다.");
    }
}
