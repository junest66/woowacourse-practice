package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.utils.RandomGenerator;

public class RealRandomGenerator<T> implements RandomGenerator<T> {
    private static final int MIN_CATEGORY_NUMBER = 1;
    private static final int MAX_CATEGORY_NUMBER = 5;

    @Override
    public T getRandomItem(List<T> list) {
        return Randoms.shuffle(list).get(0);
    }

    @Override
    public int generateRandomNumberInRange() {
        return Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER, MAX_CATEGORY_NUMBER);
    }
}
