package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputGameCountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요", "예외발생해야함"})
    void 게임_횟수_예외(String input) {
        assertThrows(IllegalArgumentException.class, () ->
            InputGameCountValidator.validateInputGameCount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "4554"})
    void 게임_횟수(String input) {
        Assertions.assertDoesNotThrow(() -> {
            InputGameCountValidator.validateInputGameCount(input);
        });
    }

}