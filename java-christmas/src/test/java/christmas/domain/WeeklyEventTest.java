package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeeklyEventTest {
    @Test
    @DisplayName("적용 가능한 평일 이벤트 혜택 금액 계산")
    void getBenefitAmount_Weekday_ShouldCalculateCorrectAmount() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.CHOCOLATE_CAKE.getKoreanName(), 2);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        WeeklyEvent event = new WeeklyEvent(menuOrder, 3);

        assertThat(event.getBenefitAmount()).isEqualTo(4046);
    }

    @Test
    @DisplayName("적용 가능한 주말 이벤트 혜택 금액 계산")
    void getBenefitAmount_Weekend_ShouldCalculateCorrectAmount() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.T_BONE_STEAK.getKoreanName(), 1);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        WeeklyEvent event = new WeeklyEvent(menuOrder, 1);

        assertThat(event.getBenefitAmount()).isEqualTo(2023);
    }

    @Test
    @DisplayName("이벤트 적용 불가능한 경우 혜택 금액 0 반환")
    void getBenefitAmount_EventCannotApply_ShouldReturnZero() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.ICE_CREAM.getKoreanName(), 1);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        WeeklyEvent event = new WeeklyEvent(menuOrder, 3);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("유효하지 않은 날짜 입력시 혜택 금액 0 반환")
    void getBenefitAmount_InvalidDay_ShouldReturnZero() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.SEAFOOD_PASTA.getKoreanName(), 2);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        WeeklyEvent event = new WeeklyEvent(menuOrder, 40);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("주말 할인 이벤트에서 디저트 주문시 혜택 금액 0 반환")
    void getBenefitAmount_WeekendDessertOrder_ShouldReturnZero() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.CHOCOLATE_CAKE.getKoreanName(), 2);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        WeeklyEvent event = new WeeklyEvent(menuOrder, 1);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("평일 할인 이벤트에서 메인 요리 주문시 혜택 금액 0 반환")
    void getBenefitAmount_WeekdayMainDishOrder_ShouldReturnZero() {
        Map<String, Integer> menuOrderMap = new HashMap<>();
        menuOrderMap.put(Menu.BBQ_RIBS.getKoreanName(), 1);
        MenuOrder menuOrder = new MenuOrder(menuOrderMap);
        WeeklyEvent event = new WeeklyEvent(menuOrder, 3);

        assertThat(event.getBenefitAmount()).isEqualTo(0);
    }

}
