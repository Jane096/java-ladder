package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import reladder.domain.Height;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("입력 값이 0보다 큰 숫자라면 height를 생성한다.")
    void heightGenerateTest(int input) {
        Height height = Height.of(input);
        assertThat(height.getHeight()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, 0})
    @DisplayName("입력 값이 0이거나 음수라면 예외를 발생시킨다.")
    void heightGenerateFailTest(int input) {
        assertThatThrownBy(() -> Height.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이가 0이거나 음수일 수 없습니다.");
    }
}
