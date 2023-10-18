package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputCarNamesValidatorTest {

    @Test
    void 자동차이름_입력_예외() {
        String longCarNames = "short,toolongname";

        assertThrows(IllegalArgumentException.class, () -> {
            InputCarNamesValidator.validateInputCarNames(longCarNames);
        });
    }
}