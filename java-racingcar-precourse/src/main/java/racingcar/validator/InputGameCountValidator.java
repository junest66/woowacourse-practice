package racingcar.validator;

import racingcar.message.Message;

public class InputGameCountValidator {

    public static int validateInputGameCount(String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.COUNT_INPUT_ERROR_MESSAGE);
        }
        return count;
    }

}
