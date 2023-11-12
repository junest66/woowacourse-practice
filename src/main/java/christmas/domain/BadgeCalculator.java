package christmas.domain;

import christmas.constants.Values;

public class BadgeCalculator {
    public String calculateBadge(DiscountResult discountResult) {
        int totalDiscountAmount = discountResult.getTotalAllDiscountAmount() * -1;

        if (totalDiscountAmount >= Values.BADGE_SANTA_REQUIREMENT) {
            return Values.BADGE_SANTA;
        }
        if (totalDiscountAmount >= Values.BADGE_TREE_REQUIREMENT) {
            return Values.BADGE_TREE;
        }
        if (totalDiscountAmount >= Values.BADGE_STAR_REQUIREMENT) {
            return Values.BADGE_STAR;
        }
        return Values.NOT_EXIST;
    }
}
