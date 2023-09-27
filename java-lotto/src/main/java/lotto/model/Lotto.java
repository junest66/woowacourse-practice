package lotto.model;

import java.util.*;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> numberSet = new HashSet<>(numbers);

        if(numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException();
        }

        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
    // TODO: 추가 기능 구현
}
