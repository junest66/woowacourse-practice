package menu.validator;

import java.util.Arrays;
import java.util.List;
import menu.constants.FoodMenu;

public class RestrictedMenuValidation {
    private static final String SEPARATOR = ",";
    private static final int MINIMUM_RESTRICTED_MENUS = 0;
    private static final int MAXIMUM_RESTRICTED_MENUS = 2;
    private static final String MENU_COUNT_ERROR_MESSAGE =
            "[ERROR] 먹지 못하는 음식의 갯수은 최소 " + MINIMUM_RESTRICTED_MENUS + "개 최대 " + MAXIMUM_RESTRICTED_MENUS + "개 입니다.";
    private static final String INVALID_MENU_ERROR_MESSAGE = "[ERROR] 없는 메뉴입니다. 다시 입력해주세요.";

    public void validate(String input) {
        List<String> menuNames = Arrays.asList(input.split(SEPARATOR));
        checkMenuCount(menuNames);
        checkValidMenu(menuNames);
    }

    private void checkMenuCount(List<String> menuNames) {
        if (menuNames.size() < MINIMUM_RESTRICTED_MENUS || menuNames.size() > MAXIMUM_RESTRICTED_MENUS) {
            throw new IllegalArgumentException(MENU_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkValidMenu(List<String> menuNames) {
        for (String menuName : menuNames) {
            if (!FoodMenu.isValidName(menuName)) {
                throw new IllegalArgumentException(INVALID_MENU_ERROR_MESSAGE);
            }
        }
    }
}
