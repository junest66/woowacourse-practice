package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void movePosition() {
        if(getRandomNumber() >= 4) {
           this.position++;
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
