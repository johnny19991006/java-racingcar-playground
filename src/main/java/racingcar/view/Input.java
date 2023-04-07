package racingcar.view;

import racingcar.domain.Name;
import racingcar.util.StringValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static racingcar.util.message.ErrorMessage.CAR_DUPLICATE;

public class Input {
    private static final String FORMAT_PATTERN = "(([a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣]+)(,)?)+";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT = ",";

    public static List<Name> inputNamesUi() {
        Output.printInputNamesUi();

        String input = scanner.nextLine();
        StringValidator.validateFormatByRegex(input, FORMAT_PATTERN);

        List<Name> names = mapStringListToNameList(splitInput(input));
        validateDuplicated(names);

        return names;
    }

    public static int inputTryCountUi() {
        Output.printInputTryCountUi();
        return scanner.nextInt();
    }

    private static void validateDuplicated(List<Name> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(CAR_DUPLICATE.getMessage());
        }
    }

    private static List<String> splitInput(String input) {
        return Arrays.stream(input.split(SPLIT))
                .collect(Collectors.toList());
    }

    private static List<Name> mapStringListToNameList(List<String> stringList) {
        return stringList.stream()
                .map(Name::from)
                .collect(Collectors.toList());
    }
}
