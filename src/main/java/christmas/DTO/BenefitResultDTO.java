package christmas.DTO;

import christmas.domain.BenefitResult;
import java.util.Map;

public record BenefitResultDTO(Map<String, Integer> eventResult) {
    public BenefitResultDTO(BenefitResult benefitResult) {
        this(benefitResult.getBenefitResult());
    }

    public boolean isAllZeroValues() {
        return eventResult.values().stream().allMatch(value -> value == 0);
    }
}
