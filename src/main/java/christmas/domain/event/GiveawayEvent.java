package christmas.domain.event;

import christmas.constants.Values;
import christmas.domain.Order;

public class GiveawayEvent implements Event {
    private final Order order;

    @Override
    public String getEventName() {
        return Values.GIVEAWAY_EVENT_NAME;
    }

    public GiveawayEvent(Order order) {
        this.order = order;
    }

    @Override
    public int calculateDiscount() {
        if (isNotApplicable()) {
            return 0;
        }
        return Values.CHAMPAGNE_PRICE;
    }

    private boolean isNotApplicable() {
        if (order.getDate() < Values.MINIMUM_DATE_FOR_EVENT || order.getDate() > Values.MAXIMUM_DATE_FOR_EVENT) {
            return true;
        }
        if (order.calculateTotalPriceBeforeDiscount() < Values.MINIMUM_TOTAL_ORDER_AMOUNT_FOR_GIVEAWAY_EVENT) {
            return true;
        }
        return false;
    }
}
