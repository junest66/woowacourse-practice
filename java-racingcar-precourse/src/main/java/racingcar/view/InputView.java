package racingcar.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Message;
import racingcar.validator.InputCarNamesValidator;
import racingcar.validator.InputGameCountValidator;

public class InputView {

    public static List<String> getCarNames() {
        List<String> carNames;
        while(true) {
            System.out.println(Message.CAR_INPUT_MESSAGE);
            String name = Console.readLine();
            try {
                carNames = InputCarNamesValidator.validateInputCarNames(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carNames;
    }

    public static int getGameCount() {
        int count;
        while(true) {
            System.out.println(Message.COUNT_INPUT_MESSAGE);
            String input = Console.readLine();
            try {
                count = InputGameCountValidator.validateInputGameCount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return count;
    }

}
