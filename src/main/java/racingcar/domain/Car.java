package racingcar.domain;


public class Car {
    private static final int MIN_MOVABLE_VALUE = 4;
    private static final String DISTANCE_BAR = "-";
    public static final int MIN_POSITION = 0;

    private final Name name;
    private int position;

    private Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name, int position) {
        return new Car(Name.from(name), position);
    }

    public boolean move(int value) {
        boolean willMove = value >= MIN_MOVABLE_VALUE;
        if (willMove) {
            position++;
        }
        return willMove;
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public String positionBar() {
        return DISTANCE_BAR.repeat(position);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, positionBar());
    }


}
