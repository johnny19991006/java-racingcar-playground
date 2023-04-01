package racingcar.util;

import static racingcar.util.message.ErrorMessage.STRING_FORMAT;
import static racingcar.util.message.ErrorMessage.STRING_LENGTH;
import static racingcar.util.message.ErrorMessage.STRING_IS_EMPTY;

public class StringValidator {
    public static void validateIsEmpty(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException(STRING_IS_EMPTY.getMessage());
        }
    }

    public static void validateLength(String text, int max) {
        if (text.length() > max) {
            throw new IllegalArgumentException(
                    String.format(STRING_LENGTH.getMessage())
            );
        }
    }

    public static void validateFormatByRegex(String text, String regex) {
        if (!text.matches(regex)) {
            throw new IllegalArgumentException(STRING_FORMAT.getMessage());
        }
    }
}
