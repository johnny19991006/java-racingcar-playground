package racingcarTest.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @DisplayName("Cars 에 같은 Name 을 가진 Car 가 추가되면 예외가 발생 한다.")
    @Test
    void add() {
        Cars cars = Cars.create();
        cars.add(Car.of("car1", 0));

        assertThatThrownBy(() -> cars.add(Car.of("car1", 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Cars 가 우승자의 이름을 반환한다.")
    @Test
    void getWinnersNames() {
        Cars cars = Cars.create();
        cars.add(Car.of("car1", 5));
        cars.add(Car.of("car2", 3));
        cars.add(Car.of("car3", 5));

        assertThat(cars.getWinnersNames())
                .containsExactly(Name.from("car3"), Name.from("car1"));
    }

    @DisplayName("moveAll 메소드가 모든 차를 전진시킨다.")
    @Test
    void moveAll() {
        RandomGenerator randomGenerator = new RandomGenerator();

        Cars cars = Cars.create();
        cars.add(Car.of("car1", 0));
        cars.add(Car.of("car2", 0));
        cars.add(Car.of("car3", 0));
        cars.add(Car.of("car4", 0));
        cars.add(Car.of("car5", 0));

        for (int i = 0; i < 30; i++) {
            cars.moveAll(randomGenerator);
        }

        assertThat(cars.toString()).isEqualTo(
                "car1 : --------------\n" +
                        "car2 : ---------------\n" +
                        "car3 : ----------------\n" +
                        "car4 : ---------------\n" +
                        "car5 : --------------");
    }
}
