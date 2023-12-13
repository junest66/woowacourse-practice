package menu.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RestrictedMenuValidation 클래스 테스트")
public class RestrictedMenuValidationTest {

    @Test
    @DisplayName("유효한 입력일때 예외가 발생하지 않을 때의 테스트")
    public void testNoException() {
        RestrictedMenuValidation validator = new RestrictedMenuValidation();
        assertDoesNotThrow(() -> validator.validate("김밥,깐풍기"));
    }

    @Test
    @DisplayName("유효하지 않은 메뉴 검증 테스트")
    public void testInvalidMenuValidation() {
        RestrictedMenuValidation validator = new RestrictedMenuValidation();

        assertThatThrownBy(() -> validator.validate("치킨, 치즈돈가스"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 없는 메뉴입니다. 다시 입력해주세요.");
    }

    @Test
    @DisplayName("메뉴 갯수 검증 테스트")
    public void testMenuCountValidation() {
        RestrictedMenuValidation validator = new RestrictedMenuValidation();

        assertThatThrownBy(() -> validator.validate("피자,짬뽕,스파게티"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 먹지 못하는 음식의 갯수은 최소 0개 최대 2개 입니다.");
    }
}
