package menu.validator;

import java.util.Arrays;
import java.util.List;

public class CoachNamesValidation {
    private static final String SEPARATOR = ",";
    private static final int MIN_COACHES = 2;
    private static final int MAX_COACHES = 5;
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final String COACH_COUNT_ERROR_MESSAGE = "[ERROR] 코치는 최소 " + MIN_COACHES + "명 이상입력해야 합니다";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 코치의 이름은 최소 " + MIN_NAME_LENGTH + "글자 최대 " + MAX_NAME_LENGTH + "글자 입니다.";

    public void validate(String input) {
        List<String> names = Arrays.asList(input.split(SEPARATOR));
        checkCoachCount(names);
        for (String name : names) {
            checkNamesLength(name);
        }
    }

    public void checkCoachCount(List<String> names) {
        if (names.size() < MIN_COACHES || names.size() > MAX_COACHES) {
            throw new IllegalArgumentException(COACH_COUNT_ERROR_MESSAGE);
        }
    }

    public void checkNamesLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
