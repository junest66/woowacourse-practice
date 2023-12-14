package pairmatching.validator;

public class FunctionValidator {
    public static final String FUNCTION_PAIR_MATCHING = "1";
    public static final String FUNCTION_PAIR_QUERY = "2";
    public static final String FUNCTION_PAIR_RESET = "3";
    public static final String FUNCTION_QUIT = "Q";

    public static final String ERROR_INVALID_INPUT = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요";

    public static void validate(String input) {
        if (!FUNCTION_PAIR_MATCHING.equals(input)
                && !FUNCTION_PAIR_QUERY.equals(input)
                && !FUNCTION_PAIR_RESET.equals(input)
                && !FUNCTION_QUIT.equals(input)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }
}
