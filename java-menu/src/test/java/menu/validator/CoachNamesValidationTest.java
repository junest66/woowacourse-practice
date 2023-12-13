package menu.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CoachNamesValidationTest {
    CoachNamesValidation validator = new CoachNamesValidation();

    @Test
    @DisplayName("올바른 코치 이름 목록 테스트")
    public void testValidCoachNames() {
        assertDoesNotThrow(() -> validator.validate("토미,제임스,포코"));
    }

    @Test
    @DisplayName("최소 코치 수 미달로 예외 발생 테스트")
    public void testMinCoachCount() {
        CoachNamesValidation validator = new CoachNamesValidation();
        assertThatThrownBy(() -> validator.validate("토미"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치는 최소 2명 이상입력해야 합니다");
    }

    @Test
    @DisplayName("최대 코치 수 초과로 예외 발생 테스트")
    public void testMaxCoachCount() {
        CoachNamesValidation validator = new CoachNamesValidation();
        assertThatThrownBy(() -> validator.validate("토미,제임스,포코,주니,후니,바미"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최소 이름 길이 미달로 예외 발생 테스트")
    public void testMinNameLength() {
        CoachNamesValidation validator = new CoachNamesValidation();
        assertThatThrownBy(() -> validator.validate("코,제임스"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치의 이름은 최소 2글자 최대 4글자 입니다.");
    }

    @Test
    @DisplayName("최대 이름 길이 초과로 예외 발생 테스트")
    public void testMaxNameLength() {
        CoachNamesValidation validator = new CoachNamesValidation();
        assertThatThrownBy(() -> validator.validate("코치12345,제임스"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치의 이름은 최소 2글자 최대 4글자 입니다.");
    }
}
