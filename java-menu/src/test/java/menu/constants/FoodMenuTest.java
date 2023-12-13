package menu.constants;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodMenuTest {
    @Test
    @DisplayName("유효한 메뉴 이름 테스트")
    public void testIsValidNameWithValidName() {
        String validName = "김밥";
        boolean isValid = FoodMenu.isValidName(validName);
        assertTrue(isValid, "유효한 메뉴 이름은 true를 반환해야 합니다.");
    }

    @Test
    @DisplayName("유효하지 않은 메뉴 이름 테스트")
    public void testIsValidNameWithInvalidName() {
        String invalidName = "치즈돈가스";
        boolean isValid = FoodMenu.isValidName(invalidName);
        assertFalse(isValid, "유효하지 않은 메뉴 이름은 false를 반환해야 합니다.");
    }
}
