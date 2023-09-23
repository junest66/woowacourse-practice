package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class User {

    private List<Integer> numbers;

    public User() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> inputNumber() {
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        return numbers;
    }
}
