package christmas.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderParsing {
    public static Map<String, Integer> parseOrder(List<String> menuList) {
        Map<String, Integer> orderMap = new HashMap<>();
        for (String item : menuList) {
            String[] parts = item.split("-");
            String menuItem = parts[0].trim();
            int quantity = Integer.parseInt(parts[1].trim());
            orderMap.put(menuItem, orderMap.getOrDefault(menuItem, 0) + quantity);
        }
        return orderMap;
    }
}
