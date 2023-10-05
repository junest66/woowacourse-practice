package bridge.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputBridgeSizeValidatorTest {

    @DisplayName("다리 길이에 숫자가 아닌 경우가 들어왔을때")
    @ValueSource(strings = {"ttt", "asd", "질"})
    @ParameterizedTest
    void validateBridgeSizeFormat(String input) {
        assertThatThrownBy(() -> InputBridgeSizeValidator.validateBridgeSizeFormat(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이에 숫자가 범위 밖인 경우")
    @ValueSource(ints = {2, 21, 100})
    @ParameterizedTest
    void validateBridgeSizeRange(int input) {
        assertThatThrownBy(() -> InputBridgeSizeValidator.validateBridgeSizeRange(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}