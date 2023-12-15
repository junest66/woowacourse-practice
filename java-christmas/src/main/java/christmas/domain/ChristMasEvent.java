package christmas.domain;

public class ChristMasEvent implements Event {
    private MenuOrder menuOrder;
    private int day;

    public ChristMasEvent(MenuOrder menuOrder, int day) {
        this.menuOrder = menuOrder;
        this.day = day;
    }

    @Override
    public String getEventName() {
        return "크리스마스 디데이 할인";
    }

    @Override
    public int getBenefitAmount() {
        if(cannotApplyEvent()) {
            return 0;
        }
        return 1000 + 100 * (day - 1);
    }

    private boolean cannotApplyEvent() {
        if(day < 1 || day > 25) {
            return true;
        }
        if(menuOrder.calculateTotalPrice() < 10000) {
            return true;
        }
        return false;
    }
}
