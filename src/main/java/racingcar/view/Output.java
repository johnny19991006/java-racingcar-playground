package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.message.OutputMessage.OUTPUT_RESULT_TEXT;
import static racingcar.util.message.OutputMessage.OUTPUT_WINNING_CAR;
import static racingcar.util.message.InputMessage.INPUT_CAR_NAME;
import static racingcar.util.message.InputMessage.INPUT_NUMBER_TO_TRY;

public class Output {
    private static final String NAME_DELIMITER = ", ";

    public static void printInputNamesUi() {
        System.out.println(INPUT_CAR_NAME.getMessage());
    }

    public static void printInputTryCountUi() {
        System.out.println(INPUT_NUMBER_TO_TRY.getMessage());
    }

    public static void printRaceResultUi() {
        System.out.println(OUTPUT_RESULT_TEXT.getMessage());
    }

    public static void printCarsUi(Cars cars) {
        System.out.println(cars);
        System.out.println();
    }

    public static void printRaceResultUi(List<Name> names) {
        String joinedNames = names.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(NAME_DELIMITER));
        System.out.printf("%s" + OUTPUT_WINNING_CAR.getMessage(), joinedNames);
    }

    public static void printErrorUi(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
