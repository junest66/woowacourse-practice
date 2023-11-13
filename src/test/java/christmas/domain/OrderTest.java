package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.MenuItem;
import christmas.constants.MenuItem.Category;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    @DisplayName("특정 카테고리의 메뉴가 몇 개있는지 계산한다")
    @Test
    void shouldCorrectlyCountNumberOfMenuItemsInEachCategory() {
        int date = 5;
        Map<MenuItem, Integer> menuOrder = new HashMap<>();
        menuOrder.put(MenuItem.해산물파스타, 5);
        menuOrder.put(MenuItem.제로콜라, 2);
        menuOrder.put(MenuItem.타파스, 1);
        menuOrder.put(MenuItem.레드와인, 1);
        Order order = new Order(date, menuOrder);
        assertThat(order.getMenuCategoryCount(Category.BEVERAGE)).isEqualTo(3);
        assertThat(order.getMenuCategoryCount(Category.APPETIZER)).isEqualTo(1);
        assertThat(order.getMenuCategoryCount(Category.MAIN)).isEqualTo(5);
    }

    @DisplayName("할인전 총 주문 금액이 얼마 인지 계산한다")
    @Test
    void shouldCorrectlyCalculateTotalOrderAmountBeforeDiscount() {
        int date = 5;
        Map<MenuItem, Integer> menuOrder = new HashMap<>();
        menuOrder.put(MenuItem.해산물파스타, 5);
        menuOrder.put(MenuItem.제로콜라, 2);
        menuOrder.put(MenuItem.타파스, 1);
        menuOrder.put(MenuItem.레드와인, 1);
        Order order = new Order(date, menuOrder);
        int expectedValue = MenuItem.해산물파스타.getPrice() * 5 + MenuItem.제로콜라.getPrice() * 2 + MenuItem.타파스.getPrice()
                + MenuItem.레드와인.getPrice();
        assertThat(order.calculateTotalPriceBeforeDiscount()).isEqualTo(expectedValue);
    }
}
