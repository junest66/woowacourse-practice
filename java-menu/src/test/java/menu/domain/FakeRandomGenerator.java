package menu.domain;

import java.util.List;
import menu.utils.RandomGenerator;

public class FakeRandomGenerator<T> implements RandomGenerator<T> {
    @Override
    public T getRandomItem(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        return list.get(0);
    }

    @Override
    public int generateRandomNumberInRange() {
        return 1;
    }
}
