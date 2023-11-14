package christmas.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프", Values.MUSHROOM_SOUP_PRICE, MenuCategory.APPETIZER),
    TAPAS("타파스", Values.TAPAS_PRICE, MenuCategory.APPETIZER),
    CAESAR_SALAD("시저샐러드", Values.CAESAR_SALAD_PRICE, MenuCategory.APPETIZER),
    TBONE_STEAK("티본스테이크", Values.TBONE_STEAK_PRICE, MenuCategory.MAIN),
    BBQ_RIBS("바비큐립", Values.BBQ_RIBS_PRICE, MenuCategory.MAIN),
    SEAFOOD_PASTA("해산물파스타", Values.SEAFOOD_PASTA_PRICE, MenuCategory.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", Values.CHRISTMAS_PASTA_PRICE, MenuCategory.MAIN),
    CHOCO_CAKE("초코케이크", Values.CHOCO_CAKE_PRICE, MenuCategory.DESSERT),
    ICE_CREAM("아이스크림", Values.ICE_CREAM_PRICE, MenuCategory.DESSERT),
    ZERO_COLA("제로콜라", Values.ZERO_COLA_PRICE, MenuCategory.BEVERAGE),
    RED_WINE("레드와인", Values.RED_WINE_PRICE, MenuCategory.BEVERAGE),
    CHAMPAGNE("샴페인", Values.CHAMPAGNE_PRICE, MenuCategory.BEVERAGE);

    private final String koreanName;
    private final int price;
    private final MenuCategory menuCategory;

    MenuItem(String koreanName, int price, MenuCategory menuCategory) {
        this.koreanName = koreanName;
        this.price = price;
        this.menuCategory = menuCategory;
    }

    public static boolean isOrderInvalid(Map<String, Integer> orderHistory) {
        return hasInvalidMenuItems(orderHistory) ||
                isOrderAllDrinks(orderHistory) ||
                hasExcessiveQuantity(orderHistory) ||
                hasInvalidQuantities(orderHistory);
    }

    public static Optional<MenuItem> findByKoreanName(String koreanName) {
        return Arrays.stream(MenuItem.values())
                .filter(menuItem -> menuItem.getKoreanName().equals(koreanName))
                .findFirst();
    }

    private static boolean hasInvalidMenuItems(Map<String, Integer> orderHistory) {
        return orderHistory.keySet().stream()
                .anyMatch(itemName -> MenuItem.findByKoreanName(itemName).isEmpty());
    }

    private static boolean isOrderAllDrinks(Map<String, Integer> orderHistory) {
        return orderHistory.keySet().stream()
                .allMatch(itemName -> MenuItem.findByKoreanName(itemName)
                        .map(menuItem -> menuItem.getMenuCategory() == MenuCategory.BEVERAGE)
                        .orElse(true));
    }

    private static boolean hasInvalidQuantities(Map<String, Integer> orderHistory) {
        return orderHistory.values().stream()
                .anyMatch(quantity -> quantity < Values.MINIMUM_MENU_QUANTITY);
    }

    private static boolean hasExcessiveQuantity(Map<String, Integer> orderHistory) {
        int totalQuantity = orderHistory.values().stream().mapToInt(Integer::intValue).sum();
        return totalQuantity > Values.MAXIMUM_TOTAL_QUANTITY;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public int getPrice() {
        return price;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

}
