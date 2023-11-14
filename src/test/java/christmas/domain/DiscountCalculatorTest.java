package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.MenuItem;
import christmas.constants.Values;
import christmas.domain.event.ChristmasDiscountEvent;
import christmas.domain.event.DayOfWeekDiscountEvent;
import christmas.domain.event.Event;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.event.SpecialDiscountEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountCalculatorTest {
    private Order order;
    private List<Event> events;

    @BeforeEach
    void setUp() {
        Map<MenuItem, Integer> menuOrder = new HashMap<>();
        menuOrder.put(MenuItem.TBONE_STEAK, 1);
        menuOrder.put(MenuItem.BBQ_RIBS, 1);
        menuOrder.put(MenuItem.CHOCO_CAKE, 2);
        menuOrder.put(MenuItem.ZERO_COLA, 1);
        order = new Order(3, menuOrder);
        events = Arrays.asList(new ChristmasDiscountEvent(order), new DayOfWeekDiscountEvent(order),
                new SpecialDiscountEvent(order), new GiveawayEvent(order));
    }

    @DisplayName("할인 정보를 계산한다")
    @Test
    void shouldCalculateTotalDiscountsCorrectly() {
        DiscountCalculator discountCalculator = new DiscountCalculator(events);
        DiscountResult expectedResult = new DiscountResult();
        expectedResult.addDiscount(Values.CHRISTMAS_EVENT_NAME, -1200);
        expectedResult.addDiscount(Values.WEEKDAY_EVENT_NAME, -4046);
        expectedResult.addDiscount(Values.SPECIAL_EVENT_NAME, -1000);
        expectedResult.addDiscount(Values.GIVEAWAY_EVENT_NAME, -25000);
        assertThat(discountCalculator.calculateDiscount()).isEqualToComparingFieldByField(expectedResult);
    }

}
