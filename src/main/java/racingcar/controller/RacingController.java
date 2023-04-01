package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.TryCount;
import racingcar.util.RandomGenerator;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class RacingController {
    private static final RandomGenerator randomGenerator = new RandomGenerator();
    private TryCount tryCount;
    private Cars cars = Cars.create();

    public RacingController() {
    }

    public void setUpCars() {
        try {
            List<Name> names = Input.inputNamesUi();
            cars = Cars.from(names);
        } catch (IllegalArgumentException exception) {
            Output.printErrorUi(exception);
            setUpCars();
        }
    }

    public void setUpTryCount() {
        try {
            int input = Input.inputTryCountUi();
            tryCount = TryCount.from(input);
            System.out.println(tryCount);
        } catch (IllegalArgumentException exception) {
            Output.printErrorUi(exception);
            setUpTryCount();
        }
    }

    public void raceStart() {
        Output.printRaceResultUi();
        for (int i = 0; i < tryCount.toInt(); i++) {
            cars.moveAll(randomGenerator);
            Output.printCarsUi(cars);
        }
    }

    public void raceEnd() {
        Output.printRaceResultUi(cars.getWinnersNames());
    }
}
