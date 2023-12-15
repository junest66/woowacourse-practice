package christmas.domain;

public class WeeklyEvent implements Event {
    private MenuOrder menuOrder;
    private int day;

    public WeeklyEvent(MenuOrder menuOrder, int day) {
        this.menuOrder = menuOrder;
        this.day = day;
    }

    @Override
    public String getEventName() {
        String name = "평일 할인";
        if (isWeekend()) {
            name = "주말 할인";
        }
        return name;
    }

    @Override
    public int getBenefitAmount() {
        if(cannotApplyEvent()) {
            return 0;
        }
        if(isWeekend()) {
            return menuOrder.countMainDishes() * 2023;
        }
        return menuOrder.countDesserts() * 2023;
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

    private boolean isWeekend() {
        return day % 7 == 1 || day % 7 == 2;
    }
}
