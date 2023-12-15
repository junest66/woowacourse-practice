package christmas.utils;

import christmas.validator.MenuOrderValidator;
import christmas.validator.VisitDayValidator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InputProcessor {
    public static int processVisitDay(String input) {
        VisitDayValidator.validate(input);
        return Integer.parseInt(input);
    }

    public static Map<String, Integer> processOrder(String input) {
        List<String> menuList = Arrays.asList(input.split(","));
        MenuOrderValidator.validate(menuList);
        return OrderParsing.parseOrder(menuList);
    }
}
