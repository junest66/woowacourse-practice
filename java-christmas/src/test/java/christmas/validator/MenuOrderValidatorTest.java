package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuOrderValidatorTest {
    @Test
    @DisplayName("유효한 주문 형식에 대해 검증 통과")
    void validate_withValidOrder_shouldPass() {
        assertDoesNotThrow(() -> MenuOrderValidator.validate(Arrays.asList("타파스-2", "제로콜라-1")));
    }

    @Test
    @DisplayName("잘못된 주문 형식에 대해 예외 발생")
    void validate_withInvalidFormat_shouldThrowException() {
        assertThatThrownBy(() -> MenuOrderValidator.validate(Arrays.asList("타파스")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("숫자가 아닌 수량에 대해 예외 발생")
    void validate_withNonNumericQuantity_shouldThrowException() {
        assertThatThrownBy(() -> MenuOrderValidator.validate(Arrays.asList("타파스-abc")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("주문 항목 제한 초과시 예외 발생")
    void validate_withTooManyItems_shouldThrowException() {
        List<String> tooManyItems = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            tooManyItems.add("메뉴" + i + "-1");
        }

        assertThatThrownBy(() -> MenuOrderValidator.validate(tooManyItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("중복된 메뉴 항목에 대해 예외 발생")
    void validate_withDuplicateMenuItems_shouldThrowException() {
        assertThatThrownBy(() -> MenuOrderValidator.validate(Arrays.asList("타파스-1", "타파스-2")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

}
