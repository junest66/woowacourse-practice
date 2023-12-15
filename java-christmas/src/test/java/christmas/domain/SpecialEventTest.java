package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialEventTest {
    @Test
    @DisplayName("특별 할인 이벤트 이름 반환")
    void getEventName_ShouldReturnSpecialDiscount() {
        SpecialEvent event = new SpecialEvent(null, 3);
        assertThat(event.getEventName()).isEqualTo("특별 할인");
    }

    @Test
    @DisplayName("특별 할인 이벤트 적용 날짜에 혜택 금액 계산")
    void getBenefitAmount_OnStarDay_ShouldReturnDiscount() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 3);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        SpecialEvent event = new SpecialEvent(menuOrder, 25);

        assertThat(event.getBenefitAmount()).isEqualTo(1000);
    }

    @Test
    @DisplayName("특별 할인 이벤트 적용 날짜가 아나묜 혜택 금액은 0")
    void getBenefitAmount_OnNotStarDay_ShouldReturnDiscount() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 3);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        SpecialEvent event = new SpecialEvent(menuOrder, 23);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("유효하지 않은 날짜 입력시 혜택 금액 0 반환")
    void getBenefitAmount_InvalidDay_ShouldReturnZero() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 2);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        SpecialEvent event = new SpecialEvent(menuOrder, 40);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }

}
