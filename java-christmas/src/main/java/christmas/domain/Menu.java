package christmas.domain;

import java.util.Map;

public enum Menu {
    MUSHROOM_SOUP(6000, MenuCategory.APPETIZER, "양송이수프"),
    TAPAS(5500, MenuCategory.APPETIZER, "타파스"),
    CAESAR_SALAD(8000, MenuCategory.APPETIZER, "시저샐러드"),

    T_BONE_STEAK(55000, MenuCategory.MAIN, "티본스테이크"),
    BBQ_RIBS(54000, MenuCategory.MAIN, "바비큐립"),
    SEAFOOD_PASTA(35000, MenuCategory.MAIN, "해산물파스타"),
    CHRISTMAS_PASTA(25000, MenuCategory.MAIN, "크리스마스파스타"),

    CHOCOLATE_CAKE(15000, MenuCategory.DESSERT, "초코케이크"),
    ICE_CREAM(5000, MenuCategory.DESSERT, "아이스크림"),

    ZERO_COLA(3000, MenuCategory.BEVERAGE, "제로콜라"),
    RED_WINE(60000, MenuCategory.BEVERAGE, "레드와인"),
    CHAMPAGNE(25000, MenuCategory.BEVERAGE, "샴페인");

    private final int price;
    private final MenuCategory category;
    private final String koreanName;

    Menu(int price, MenuCategory category, String koreanName) {
        this.price = price;
        this.category = category;
        this.koreanName = koreanName;
    }

    public static Menu getMenuByKoreanName(String koreanName) {
        for (Menu item : Menu.values()) {
            if (item.getKoreanName().equals(koreanName)) {
                return item;
            }
        }
        return null;
    }

    public static boolean isValidMenuItem(String menuItemName) {
        for (Menu item : Menu.values()) {
            if (item.getKoreanName().equals(menuItemName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBeverageOnlyOrder(Map<String, Integer> menuOrder) {
        for (String koreanName : menuOrder.keySet()) {
            Menu menuItem = getMenuByKoreanName(koreanName);
            if (menuItem == null || menuItem.getCategory() != MenuCategory.BEVERAGE) {
                return false;
            }
        }
        return true;
    }

    public int getPrice() {
        return price;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public String getKoreanName() {
        return koreanName;
    }
}
