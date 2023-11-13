package christmas.constants;

import java.util.Arrays;
import java.util.Map;

public enum MenuItem {
    양송이수프(Values.MUSHROOM_SOUP_PRICE, Category.APPETIZER),
    타파스(Values.TAPAS_PRICE, Category.APPETIZER),
    시저샐러드(Values.CAESAR_SALAD_PRICE, Category.APPETIZER),
    티본스테이크(Values.TBONE_STEAK_PRICE, Category.MAIN),
    바비큐립(Values.BBQ_RIBS_PRICE, Category.MAIN),
    해산물파스타(Values.SEAFOOD_PASTA_PRICE, Category.MAIN),
    크리스마스파스타(Values.CHRISTMAS_PASTA_PRICE, Category.MAIN),
    초코케이크(Values.CHOCO_CAKE_PRICE, Category.DESSERT),
    아이스크림(Values.ICE_CREAM_PRICE, Category.DESSERT),
    제로콜라(Values.ZERO_COLA_PRICE, Category.BEVERAGE),
    레드와인(Values.RED_WINE_PRICE, Category.BEVERAGE),
    샴페인(Values.CHAMPAGNE_PRICE, Category.BEVERAGE);

    public enum Category {
        APPETIZER, MAIN, DESSERT, BEVERAGE
    }

    private final int price;
    private final Category category;

    MenuItem(int price, Category category) {
        this.price = price;
        this.category = category;
    }

    public static boolean isOrderInvalid(Map<String, Integer> orderHistory) {
        return hasInvalidMenuItems(orderHistory) ||
                isOrderAllDrinks(orderHistory) ||
                hasExcessiveQuantity(orderHistory) ||
                hasInvalidQuantities(orderHistory);
    }

    private static boolean hasInvalidMenuItems(Map<String, Integer> orderHistory) {
        return orderHistory.keySet().stream()
                .anyMatch(itemName -> Arrays.stream(MenuItem.values())
                        .noneMatch(menuItem -> menuItem.name().equals(itemName)));
    }

    private static boolean hasInvalidQuantities(Map<String, Integer> orderHistory) {
        return orderHistory.values().stream()
                .anyMatch(quantity -> quantity < Values.MINIMUM_MENU_QUANTITY);
    }

    private static boolean hasExcessiveQuantity(Map<String, Integer> orderHistory) {
        int totalQuantity = orderHistory.values().stream().mapToInt(Integer::intValue).sum();
        return totalQuantity > Values.MAXIMUM_TOTAL_QUANTITY;
    }

    private static boolean isOrderAllDrinks(Map<String, Integer> orderHistory) {
        return orderHistory.keySet().stream()
                .allMatch(itemName -> MenuItem.valueOf(itemName).category == Category.BEVERAGE);
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
