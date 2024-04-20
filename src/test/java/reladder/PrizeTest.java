package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import reladder.domain.Prize;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "꽝,당첨,꽝", "실패,성공"})
    @DisplayName("빈 값 없이 당첨 상품 이름이 입력되면 prize를 생성한다.")
    void validationSuccessTest(String value) {
        Prize prize = new Prize(value, 0);
        assertThat(prize.getValue()).isEqualTo(value);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 값이 들어올 경우 상품객체를 생성하지 않는다.")
    void validationFailTest(String value) {
        assertThatThrownBy(() -> new Prize(value, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임 결과를 입력해주세요");
    }
}
