package christmas.domain;

import java.util.Arrays;
import java.util.List;

public class SpecialEvent implements Event {
    private final List<Integer> starDay = Arrays.asList(3, 10, 17, 24, 25, 31);
    private MenuOrder menuOrder;
    private int day;

    public SpecialEvent(MenuOrder menuOrder, int day) {
        this.menuOrder = menuOrder;
        this.day = day;
    }

    @Override
    public String getEventName() {
        return "특별 할인";
    }

    @Override
    public int getBenefitAmount() {
        if (cannotApplyEvent()) {
            return 0;
        }
        if (starDay.contains(day)) {
            return 1000;
        }
        return 0;
    }

    private boolean cannotApplyEvent() {
        if (menuOrder.calculateTotalPrice() < 10000) {
            return true;
        }
        if (day < 1 || day > 31) {
            return true;
        }
        return false;
    }
}
