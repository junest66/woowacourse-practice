package menu.utils;

import java.util.List;

public interface RandomGenerator<T> {
    T getRandomItem(List<T> list);
    int generateRandomNumberInRange();
}
