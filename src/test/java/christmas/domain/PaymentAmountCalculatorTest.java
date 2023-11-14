package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.MenuItem;
import christmas.constants.Values;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentAmountCalculatorTest {
    private Order order;
    private DiscountResult discountResult = new DiscountResult();

    @BeforeEach
    void setup() {
        Map<MenuItem, Integer> menuOrder = new HashMap<>();
        menuOrder.put(MenuItem.TBONE_STEAK, 1);
        menuOrder.put(MenuItem.BBQ_RIBS, 1);
        menuOrder.put(MenuItem.CHOCO_CAKE, 2);
        menuOrder.put(MenuItem.ZERO_COLA, 1);
        order = new Order(3, menuOrder);
        discountResult.addDiscount(Values.CHRISTMAS_EVENT_NAME, -1200);
        discountResult.addDiscount(Values.WEEKDAY_EVENT_NAME, -4046);
        discountResult.addDiscount(Values.SPECIAL_EVENT_NAME, -1000);
        discountResult.addDiscount(Values.GIVEAWAY_EVENT_NAME, -25000);
    }

    @DisplayName("지불 금액을 계산한다")
    @Test
    void shouldCalculateCorrectPaymentAmount() {
        int expectedValue = 135754;
        PaymentAmountCalculator paymentAmountCalculator = new PaymentAmountCalculator();
        int paymentAmount = paymentAmountCalculator.calculatePaymentAmount(order, discountResult);
        assertThat(paymentAmount).isEqualTo(expectedValue);
    }

}
