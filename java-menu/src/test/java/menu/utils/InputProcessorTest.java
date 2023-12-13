package menu.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputProcessorTest {
    private InputProcessor inputProcessor;

    @BeforeEach
    public void setUp() {
        inputProcessor = new InputProcessor();
    }

    @Test
    @DisplayName("정상적으로 코치들의 이름을 문자열에서 리스트로 변환한다.")
    public void testProcessCoachNames_ValidInput() {
        String input = "토미,제이슨,주니,후니";
        assertThat(inputProcessor.processCoachNames(input))
                .containsExactly("토미", "제이슨", "주니", "후니");
    }

    @Test
    @DisplayName("코치 입력 수가 5명초과면 예외가 발생한다.")
    public void testProcessCoachNames_InvalidInput() {
        String input = "토미,제이슨,주니,후니,제이스,제니";
        assertThatThrownBy(() -> inputProcessor.processCoachNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 못 먹는 음식에 입력일때 리스트로 잘 변환한다.")
    public void testProcessRestrictedMenus_ValidInput() {
        String input = "스파게티,바게트";
        assertThat(inputProcessor.processRestrictedMenus(input))
                .containsExactly("스파게티", "바게트");
    }

    @Test
    @DisplayName("못 먹는 음식이 2개 초과면 예외가 발생한다.")
    public void testProcessRestrictedMenus_InvalidInput() {
        String input = "피자,바게트,스파게티";
        assertThatThrownBy(() -> inputProcessor.processRestrictedMenus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

