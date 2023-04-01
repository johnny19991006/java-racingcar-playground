package racingcar.util;

import static racingcar.util.message.ErrorMessage.NUMBER_IS_POSITIVE;

public class NumberValidator {
    private static final int POSITIVE_STANDARD = 0;

    public static void validateIsPositive(int input) {
        if (input <= POSITIVE_STANDARD) {
            throw new IllegalArgumentException(NUMBER_IS_POSITIVE.getMessage());
        }
    }
}
