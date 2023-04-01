package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();
    private static final int RANDOM_NUMBER_RANGE = 10;

    public int generateNumber() {
        return RandomGenerator.random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
