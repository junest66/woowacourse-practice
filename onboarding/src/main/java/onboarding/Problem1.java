package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!validate(pobi) || !validate(crong)) {
            return -1;
        }
        int pobiValue = getMaxValue(pobi);
        int crongValue = getMaxValue(crong);
        answer = printValue(pobiValue, crongValue);

        return answer;
    }

    /**
     * 번호 검증하는 함수
     * @param numbers
     * @return
     */
    public static boolean validate(List<Integer> numbers) {
        if(numbers.size() != 2) {
            return false;
        }

        int firstNumber = numbers.get(0);
        int secondNumber = numbers.get(1);

        if(!checkRange(firstNumber) || !checkRange(secondNumber)) {
            return false;
        }

        if(firstNumber % 2 != 1 || secondNumber % 2 != 0) {
            return false;
        }

        if(secondNumber - firstNumber != 1) {
            return false;
        }
        return true;
    }

    /**
     * 범호 범위 확인하는 함수
     * @param number
     * @return
     */
    public static boolean checkRange(int number) {
        if(number < 1 || number > 400) {
            return false;
        }
        return true;
    }

    /**
     * 가장 큰 값을 구하는 함수
     * @param numbers
     * @return
     */
    public static int getMaxValue(List<Integer> numbers) {
        int leftMaxValue = compare(getSumValue(numbers.get(0)),getMultiplyValue(numbers.get(0)));
        int rightMaxValue = compare(getSumValue(numbers.get(1)),getMultiplyValue(numbers.get(1)));

        return compare(leftMaxValue, rightMaxValue);
    }

    /**
     * 자리수의 덧셈 값을 구하는 함수
     * @param number
     * @return
     */
    public static int getSumValue(int number) {
        int sum = 0;
        while(number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    /**
     * 각 자리수의 곱셈값 구하는 함수
     * @param number
     * @return
     */
    public static int getMultiplyValue(int number) {
        int value = 1;

        while(number != 0) {
            value *= number % 10;
            number /= 10;
        }

        return value;
    }

    /**
     * 두수를 비교하는 함수
     * @param sum
     * @param multiply
     * @return
     */
    public static int compare(int sum, int multiply) {
        return sum > multiply ? sum : multiply;
    }

    /**
     * 결과값 리턴하는 함수
     * @param pobiValue
     * @param crongValue
     * @return
     */
    public static int printValue(int pobiValue, int crongValue) {
        if (pobiValue > crongValue) {
            return 1;
        }
        if (pobiValue == crongValue) {
            return 0;
        }
        return 2;
    }
}