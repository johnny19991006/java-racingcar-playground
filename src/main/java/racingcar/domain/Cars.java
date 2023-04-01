package racingcar.domain;

import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.message.ErrorMessage.CAR_DUPLICATE;

public class Cars {
    private static final int DEFAULT_POSITION = 0;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Name> names) {
        List<Car> cars = names.stream()
                .map((name) -> Car.info(name.toString(), DEFAULT_POSITION))
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public static Cars create() {
        return new Cars(new ArrayList<>());
    }

    public void add(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(CAR_DUPLICATE.getMessage());
        }

        cars.add(car);
    }

    public void moveAll(RandomGenerator randomGenerator) {
        cars.forEach((car) -> car.move(
                randomGenerator.generateNumber())
        );
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.MIN_POSITION);
    }

    public List<Name> getWinnersNames() {
        return cars.stream()
                .filter(car -> car.getPosition() == calculateMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

}
