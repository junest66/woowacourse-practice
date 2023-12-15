package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class MenuOrder {
    private Map<Menu, Integer> result;

    public MenuOrder(Map<String, Integer> menuOrder) {
        validate(menuOrder);
        convertToMenu(menuOrder);
    }
    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<Menu, Integer> entry : result.entrySet()) {
            Menu menu = entry.getKey();
            Integer quantity = entry.getValue();
            totalPrice += menu.getPrice() * quantity;
        }
        return totalPrice;
    }

    public int countMainDishes() {
        int mainDishCount = 0;
        for (Map.Entry<Menu, Integer> entry : result.entrySet()) {
            if (entry.getKey().getCategory() == MenuCategory.MAIN) {
                mainDishCount += entry.getValue();
            }
        }
        return mainDishCount;
    }

    public int countDesserts() {
        int dessertCount = 0;
        for (Map.Entry<Menu, Integer> entry : result.entrySet()) {
            if (entry.getKey().getCategory() == MenuCategory.DESSERT) {
                dessertCount += entry.getValue();
            }
        }
        return dessertCount;
    }

    private void validate(Map<String, Integer> menuOrder) {
        for (Map.Entry<String, Integer> entry : menuOrder.entrySet()) {
            String menuItemName = entry.getKey();
            Integer quantity = entry.getValue();
            checkIfMenuExists(menuItemName);
            checkQuantity(quantity);
        }
        validateNonBeverageOrder(menuOrder);
    }

    private void checkIfMenuExists(String menuItemName) {
        if (!Menu.isValidMenuItem(menuItemName)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void checkQuantity(Integer quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateNonBeverageOrder(Map<String, Integer> menuOrder) {
        if (Menu.isBeverageOnlyOrder(menuOrder)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void convertToMenu(Map<String, Integer> menuOrder) {
        result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : menuOrder.entrySet()) {
            String menuItemName = entry.getKey();
            Integer quantity = entry.getValue();

            Menu menu = Menu.getMenuByKoreanName(menuItemName);
            if (menu != null) {
                result.put(menu, quantity);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Menu, Integer> entry : result.entrySet()) {
            Menu menu = entry.getKey();
            Integer quantity = entry.getValue();
            sb.append(menu.getKoreanName()).append(" ").append(quantity).append("개\n");
        }
        return sb.toString().trim();
    }
}
