package racingcar.util.message;

public enum ErrorMessage {

    NUMBER_IS_POSITIVE("숫자는 양수여야 합니다."),
    CAR_DUPLICATE("이미 존재하는 자동차 이름입니다."),
    STRING_IS_EMPTY("문자열은 빈값이면 안됩니다."),
    STRING_LENGTH("문자열의 길이가 5이하가 아닙니다."),
    STRING_FORMAT("올바르지 않은 형식의 문자열입니다.");

    private final String message;

    ErrorMessage(String message) {

        this.message = message;
    }

    public String getMessage() {

        return message;
    }
}
