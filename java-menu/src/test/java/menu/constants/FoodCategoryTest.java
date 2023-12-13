package menu.constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodCategoryTest {
    @Test
    @DisplayName("유효한 숫자로 카테고리 찾기")
    public void testFindByNumberWithValidNumber() {
        int validNumber = 3; // Replace with a valid category number
        FoodCategory category = FoodCategory.findByNumber(validNumber);
        assertThat(category)
                .isNotNull()
                .extracting(FoodCategory::getNumber)
                .isEqualTo(validNumber);
    }

    @Test
    @DisplayName("유효하지 않은 숫자로 카테고리 찾기")
    public void testFindByNumberWithInvalidNumber() {
        int invalidNumber = 10;

        assertThatThrownBy(() -> FoodCategory.findByNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않는 숫자입니다. " + invalidNumber);
    }

}
