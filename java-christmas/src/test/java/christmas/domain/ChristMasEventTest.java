package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristMasEventTest {

    @Test
    @DisplayName("크리스마스 디데이 할인 이벤트 이름 확인")
    public void shouldReturnCorrectEventName() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 3);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        ChristMasEvent event = new ChristMasEvent(menuOrder, 15);

        assertThat(event.getEventName()).isEqualTo("크리스마스 디데이 할인");
    }

    @Test
    @DisplayName("혜택 금액 적용 - 날짜 및 주문 금액 적합")
    public void shouldCalculateBenefitAmountCorrectly() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 3);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        ChristMasEvent event = new ChristMasEvent(menuOrder, 10);

        assertThat(event.getBenefitAmount()).isEqualTo(1000 + 100 * (10 - 1));
    }

    @Test
    @DisplayName("혜택 금액 미적용 - 날짜 무효")
    public void shouldReturnZeroForInvalidDay() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 3);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        ChristMasEvent event = new ChristMasEvent(menuOrder, 26);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("혜택 금액 미적용 - 주문 금액 부족")
    public void shouldReturnZeroForInsufficientOrderAmount() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.CAESAR_SALAD.getKoreanName(), 1);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        ChristMasEvent event = new ChristMasEvent(menuOrder, 10);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }
}
