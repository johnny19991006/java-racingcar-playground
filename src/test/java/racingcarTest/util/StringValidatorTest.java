package racingcarTest.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.StringValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StringValidatorTest {
    private static final String NAME_PATTERN = "[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣]+";

    @DisplayName("validateIsEmpty 메소드에 빈값이 전달되지 않으면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1111"})
    void validateIsEmptyWithNotEmptyString(String input) {
        assertDoesNotThrow(() -> StringValidator.validateIsEmpty(input));
    }

    @DisplayName("validateIsEmpty 메소드에 빈값이 전달되면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void validateIsEmptyWithEmptyString(String input) {
        assertThatThrownBy(() -> StringValidator.validateIsEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자열은 빈값이면 안됩니다.");
    }

    @DisplayName("validateLength 메소드에 다섯글자 초과의 문자열이 전달되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef"})
    void validateLengthWithInvalidLength(String input) {
        assertThatThrownBy(() -> StringValidator.validateLength(input,  5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자열의 길이가 5이하가 아닙니다.");
    }

    @DisplayName("validateFormatByRegex 메소드가 전달받은 문자열이 전달받은 정규표현식을 통과하면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"jun", "tonic", "a", "킴", "준", "123"})
    void validateFormatWithValidInput(String input) {
        assertDoesNotThrow(() -> StringValidator.validateFormatByRegex(input, NAME_PATTERN));
    }

    @DisplayName("validateFormatByRegex 메소드가 전달받은 문자열이 전달받은 정규표현식을 통과하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "twe&", "?a1"})
    void validateFormatWithInvalidInput(String input) {
        assertThatThrownBy(() -> StringValidator.validateFormatByRegex(input, NAME_PATTERN))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 형식의 문자열입니다.");
    }
}
