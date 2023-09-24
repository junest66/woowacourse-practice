package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private List<Integer> numbers;
    private String startNumber;

    public User() {
        this.startNumber = "1";
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    public List<Integer> inputNumber() {
        String input = Console.readLine();
        validation(input);
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        return numbers;
    }

    public void validation(String input) throws IllegalArgumentException {

        //세자리가 아닌경우
        if(input.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        }

        //숫자를 입력안한경우
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) < '1' || input.charAt(i) > '9') {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리 자연수가 아닙니다.)");
            }
        }

        //서로 다른 숫자가 아닌경우
        Set<Character> numbers = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (numbers.contains(input.charAt(i))) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자)");
            }
            numbers.add(input.charAt(i));
        }
    }
}
