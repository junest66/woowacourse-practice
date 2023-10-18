package racingcar.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.message.Message;

public class InputCarNamesValidator {

    public static List<String> validateInputCarNames(String names) {
        String[] carNames = names.split(",");
        for (String carName : carNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException(Message.CAR_NAME_INPUT_ERROR_MESSAGE);
            }
        }
        return new ArrayList<>(Arrays.asList(carNames));
    }
}
