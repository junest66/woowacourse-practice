package christmas.DTO;

import christmas.domain.DiscountResult;
import java.util.Map;

public record DiscountResultDTO(Map<String, Integer> eventResult) {
    public DiscountResultDTO(DiscountResult discountResult) {
        this(discountResult.getEventResult());
    }

    public boolean isAllZeroValues() {
        return eventResult.values().stream().allMatch(value -> value == 0);
    }
}
