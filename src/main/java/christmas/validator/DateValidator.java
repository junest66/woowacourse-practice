package christmas.validator;

public class DateValidator {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final String INVALID_DATE_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static void validate(String input) {
        if (isNotNumber(input) || isDateOutOfRange(Integer.parseInt(input))) {
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
    }

    private static boolean isNotNumber(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static boolean isDateOutOfRange(int date) {
        return date < MIN_DATE || date > MAX_DATE;
    }
}
