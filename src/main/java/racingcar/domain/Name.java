package racingcar.domain;

import racingcar.util.StringValidator;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String input) {
        StringValidator.validateIsEmpty(input);
        StringValidator.validateLength(input, MAX_LENGTH);
        return new Name(input);
    }

    @Override
    public String toString() {
        return name;
    }
}
