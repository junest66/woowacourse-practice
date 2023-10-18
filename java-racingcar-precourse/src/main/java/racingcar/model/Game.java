package racingcar.model;

import java.util.List;

public class Game {

    private int count;
    private List<Car> cars;

    public Game() {
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getCount() {
        return this.count;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
