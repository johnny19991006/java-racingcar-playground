package racingcarTest.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.NumberValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NumberValidatorTest {

    @DisplayName("validateIsPositive 메소드에 양수가 전달되면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 22, 333})
    void validateIsPositiveWithValidInput(int input) {
        assertDoesNotThrow(() -> NumberValidator.validateIsPositive(input));
    }

    @DisplayName("validateIsPositive 메소드에 양수가 아닌 숫자가 전달되면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -22, 0})
    void validateIsPositiveWithNotPositive(int input) {
        assertThatThrownBy(() -> NumberValidator.validateIsPositive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 양수여야 합니다.");
    }

}
