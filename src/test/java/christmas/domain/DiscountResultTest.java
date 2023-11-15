package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.EventType;
import christmas.constants.Values;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountResultTest {
    DiscountResult discountResult = new DiscountResult();

    @BeforeEach
    void setup() {
        discountResult.addDiscount(EventType.CHRISTMAS.getDisplayName(), -1200);
        discountResult.addDiscount(EventType.WEEKDAY.getDisplayName(), -4046);
        discountResult.addDiscount(EventType.SPECIAL.getDisplayName(), -1000);
        discountResult.addDiscount(EventType.GIVEAWAY.getDisplayName(), -25000);
    }

    @DisplayName("addDiscount 메서드가 할인 정보를 정확히 추가한다")
    @Test
    void addDiscountShouldAddCorrectDiscountInfo() {
        String eventName = EventType.WEEKDAY.getDisplayName();
        int discountAmount = -4046;
        DiscountResult tempDiscountResult = new DiscountResult();
        tempDiscountResult.addDiscount(eventName, discountAmount);
        assertThat(tempDiscountResult.getEventResult()).containsEntry(eventName, discountAmount);
    }

    @DisplayName("전체 혜택금액을 계산한다")
    @Test
    void shouldCorrectlyCalculateTotalDiscountAmount() {
        int expectedValue = -31246;
        assertThat(discountResult.getTotalAllDiscountAmount()).isEqualTo(expectedValue);
    }

    @DisplayName("전체 할인금액을 계산한다")
    @Test
    void shouldCorrectlyCalculateTotalDiscountAmountExcludingGiveaway() {
        int expectedValue = -6246;
        assertThat(discountResult.getTotalDiscountAmountExcludingGiveaway()).isEqualTo(expectedValue);
    }

    @DisplayName("증정 이벤트의 혜택이 0이 아니면 증정메뉴는 '샴폐인 1개' 이다.")
    @Test
    void shouldReturnChampagneWhenGiveawayBenefitIsNotZero() {
        String expectedValue = Values.GIVEAWAY_EVENT_ITEMS;
        assertThat(discountResult.getGiveawayMenu()).isEqualTo(expectedValue);
    }

    @DisplayName("증정 이벤트의 혜택이 0이면 증정메뉴는 '없음' 이다.")
    @Test
    void shouldReturnNoneWhenGiveawayBenefitIsZero() {
        discountResult.addDiscount(EventType.GIVEAWAY.getDisplayName(), 0);
        String expectedValue = Values.NOT_EXIST;
        assertThat(discountResult.getGiveawayMenu()).isEqualTo(expectedValue);
    }
}
