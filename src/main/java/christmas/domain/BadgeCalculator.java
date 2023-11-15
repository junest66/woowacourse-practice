package christmas.domain;

import christmas.constants.Badge;
import christmas.constants.Values;

public class BadgeCalculator {
    public String calculateBadge(DiscountResult discountResult) {
        int totalDiscountAmount = discountResult.getTotalAllDiscountAmount() * -1;
        if (totalDiscountAmount >= Badge.SANTA.getRequirement()) {
            return Badge.SANTA.getName();
        }
        if (totalDiscountAmount >= Badge.TREE.getRequirement()) {
            return Badge.TREE.getName();
        }
        if (totalDiscountAmount >= Badge.STAR.getRequirement()) {
            return Badge.STAR.getName();
        }
        return Values.NOT_EXIST;
    }
}
