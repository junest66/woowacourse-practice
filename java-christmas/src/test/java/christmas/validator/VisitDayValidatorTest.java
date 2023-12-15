package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisitDayValidatorTest {
    @Test
    @DisplayName("유효한 날짜 입력시 검증 통과")
    void validate_withValidDay_shouldPass() {
        assertDoesNotThrow(() -> VisitDayValidator.validate("15"));
    }

    @Test
    @DisplayName("숫자가 아닌 입력시 예외 발생")
    void validate_withNonNumericInput_shouldThrowException() {
        assertThatThrownBy(() -> VisitDayValidator.validate("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("날짜 범위를 벗어난 입력시 예외 발생")
    void validate_withOutOfRangeDay_shouldThrowException() {
        assertThatThrownBy(() -> VisitDayValidator.validate("32"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

}
