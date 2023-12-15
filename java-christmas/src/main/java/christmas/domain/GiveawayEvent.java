package christmas.domain;

public class GiveawayEvent implements Event {
    private MenuOrder menuOrder;
    private int day;

    public GiveawayEvent(MenuOrder menuOrder, int day) {
        this.menuOrder = menuOrder;
        this.day = day;
    }

    @Override
    public String getEventName() {
        return "증정 이벤트";
    }

    @Override
    public int getBenefitAmount() {
        if(cannotApplyEvent()) {
            return 0;
        }
        return 25000;
    }

    private boolean cannotApplyEvent() {
        if(menuOrder.calculateTotalPrice() < 120000) {
            return true;
        }
        if(day < 1 || day > 31) {
            return true;
        }
        return false;
    }
}
