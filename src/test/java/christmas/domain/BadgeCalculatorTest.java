package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Badge;
import christmas.constants.EventType;
import christmas.constants.Values;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeCalculatorTest {
    @DisplayName("총 혜택 금액이 2만원 이상일시 산타 배지를 부여한다.")
    @Test
    void shouldAwardSantaBadgeForTotalDiscountsOverTwentyThousand() {
        String expectedValue = Badge.SANTA.getName();
        DiscountResult discountResult = new DiscountResult();
        discountResult.addDiscount(EventType.CHRISTMAS.getDisplayName(), -1200);
        discountResult.addDiscount(EventType.WEEKDAY.getDisplayName(), -4046);
        discountResult.addDiscount(EventType.SPECIAL.getDisplayName(), -1000);
        discountResult.addDiscount(EventType.GIVEAWAY.getDisplayName(), -25000);
        BadgeCalculator badgeCalculator = new BadgeCalculator();
        String badge = badgeCalculator.calculateBadge(discountResult);
        assertThat(badge).isEqualTo(expectedValue);
    }

    @DisplayName("총 혜택 금액이 1만원 이상 2만원 미만일시 트리 배지를 부여한다.")
    @Test
    void shouldAwardTreeBadgeForTotalDiscountsBetweenTenAndTwentyThousand() {
        String expectedValue = Badge.TREE.getName();
        DiscountResult discountResult = new DiscountResult();
        discountResult.addDiscount(EventType.CHRISTMAS.getDisplayName(), -3400);
        discountResult.addDiscount(EventType.WEEKDAY.getDisplayName(), -6069);
        discountResult.addDiscount(EventType.SPECIAL.getDisplayName(), -1000);
        discountResult.addDiscount(EventType.GIVEAWAY.getDisplayName(), 0);
        BadgeCalculator badgeCalculator = new BadgeCalculator();
        String badge = badgeCalculator.calculateBadge(discountResult);
        assertThat(badge).isEqualTo(expectedValue);
    }

    @DisplayName("총 혜택 금액이 5천원 이상 1만원 미만일시 별 배지를 부여한다.")
    @Test
    void shouldAwardStarBadgeForTotalDiscountsBetweenFiveAndTenThousand() {
        String expectedValue = Badge.STAR.getName();
        DiscountResult discountResult = new DiscountResult();
        discountResult.addDiscount(EventType.CHRISTMAS.getDisplayName(), -1200);
        discountResult.addDiscount(EventType.WEEKDAY.getDisplayName(), -4046);
        discountResult.addDiscount(EventType.SPECIAL.getDisplayName(), -1000);
        discountResult.addDiscount(EventType.GIVEAWAY.getDisplayName(), -0);
        BadgeCalculator badgeCalculator = new BadgeCalculator();
        String badge = badgeCalculator.calculateBadge(discountResult);
        assertThat(badge).isEqualTo(expectedValue);
    }

    @DisplayName("총 혜택 금액이 5천원 미만일시 배지 없음을 반환한다.")
    @Test
    void shouldReturnNoBadgeForTotalDiscountsUnderFiveThousand() {
        String expectedValue = Values.NOT_EXIST;
        DiscountResult discountResult = new DiscountResult();
        discountResult.addDiscount(EventType.CHRISTMAS.getDisplayName(), -1200);
        discountResult.addDiscount(EventType.WEEKDAY.getDisplayName(), 0);
        discountResult.addDiscount(EventType.SPECIAL.getDisplayName(), -1000);
        discountResult.addDiscount(EventType.GIVEAWAY.getDisplayName(), -0);
        BadgeCalculator badgeCalculator = new BadgeCalculator();
        String badge = badgeCalculator.calculateBadge(discountResult);
        assertThat(badge).isEqualTo(expectedValue);
    }
}
