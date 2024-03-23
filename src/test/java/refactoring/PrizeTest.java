package refactoring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import refactoring.model.Height;
import refactoring.model.Prize;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "꽝,당첨,꽝", "실패,성공"})
    void validationSuccessTest(String value) {
        Prize prize = new Prize(value);
        assertThat(prize.getValue()).isEqualTo(value);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validationFailTest(String value) {
        assertThatThrownBy(() -> new Prize(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임 결과를 입력해주세요");
    }
}
