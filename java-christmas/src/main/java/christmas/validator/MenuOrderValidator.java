package christmas.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuOrderValidator {
    public static void validate(List<String> menuList) {
        checkOrderFormat(menuList);
        checkMaximumMenuLimitExceeded(menuList);
        checkForDuplicateMenuItems(menuList);
    }

    private static void checkOrderFormat(List<String> menuList) {
        for (String item : menuList) {
            String[] parts = item.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            checkNumeric(parts);
        }
    }

    private static void checkNumeric(String[] parts) {
        try {
            Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void checkMaximumMenuLimitExceeded(List<String> menuList) {
        if (menuList.size() > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void checkForDuplicateMenuItems(List<String> menuList) {
        Set<String> menuItems = new HashSet<>();
        for (String item : menuList) {
            String menuItemName = item.split("-")[0].trim();
            if (menuItems.contains(menuItemName)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            menuItems.add(menuItemName);
        }
    }

}
