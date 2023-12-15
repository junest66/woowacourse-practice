package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiveawayEventTest {
    @Test
    @DisplayName("증정 이벤트 이름 확인")
    public void shouldReturnCorrectEventName() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 3);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        GiveawayEvent event = new GiveawayEvent(menuOrder, 15);

        assertThat(event.getEventName()).isEqualTo("증정 이벤트");
    }

    @Test
    @DisplayName("혜택 금액 적용 - 주문 금액 충분")
    public void shouldReturnBenefitAmountWhenOrderIsEligible() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 3);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        GiveawayEvent event = new GiveawayEvent(menuOrder, 10);

        assertThat(event.getBenefitAmount()).isEqualTo(25000);
    }

    @Test
    @DisplayName("혜택 금액 미적용 - 주문 금액 부족")
    public void shouldReturnZeroWhenOrderAmountIsInsufficient() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 1);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        GiveawayEvent event = new GiveawayEvent(menuOrder, 10);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("혜택 금액 미적용 - 날짜 무효")
    public void shouldReturnZeroForInvalidDay() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 3);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        GiveawayEvent event = new GiveawayEvent(menuOrder, 35);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }

}
