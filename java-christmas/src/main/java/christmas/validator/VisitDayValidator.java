package christmas.validator;

public class VisitDayValidator {
    public static void validate(String input) {
        checkNumeric(input);
        checkDayRange(input);
    }

    private static void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static void checkDayRange(String input) {
        Integer day = Integer.parseInt(input);
        if(day < 1 || day > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
