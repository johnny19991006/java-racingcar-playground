package racingcar.util.message;

public enum OutputMessage {

    OUTPUT_RESULT_TEXT("\n실행 결과"),
    OUTPUT_WINNING_CAR("가 최종 우승했습니다.");

    private final String message;

    OutputMessage(String message) {

        this.message = message;
    }

    public String getMessage() {

        return message;
    }
}
