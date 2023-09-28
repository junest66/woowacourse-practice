package lotto.model;

import lotto.constant.ErrorOutputMessage;

import java.util.*;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorOutputMessage.LOTTO_LENGTH);
        }

        Set<Integer> numberSet = new HashSet<>(numbers);

        if(numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(ErrorOutputMessage.LOTTO_DUPLICATED);
        }

        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorOutputMessage.LOTTO_RANGE);
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
