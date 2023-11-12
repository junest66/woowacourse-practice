package christmas.validator;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuOrderValidator {
    private static final String INVALID_ORDER_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void validate(String input) {
        List<String> items = Arrays.asList(input.split(","));
        if (isInvalidOrderFormat(items) || hasDuplicateItems(items)) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    private static boolean isInvalidOrderFormat(List<String> items) {
        return items.stream()
                .anyMatch(item -> !item.matches("[가-힣a-zA-Z]+-\\d+"));
    }


    private static boolean hasDuplicateItems(List<String> items) {
        Set<String> uniqueItems = items.stream()
                .map(item -> item.split("-")[0].trim())
                .collect(Collectors.toSet());
        return uniqueItems.size() < items.size();
    }
}
