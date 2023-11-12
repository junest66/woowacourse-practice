package christmas.domain;

import christmas.domain.event.Event;
import java.util.List;

public class DiscountCalculator {
    private List<Event> events;

    public DiscountCalculator(List<Event> events) {
        this.events = events;
    }

    public DiscountResult calculateDiscount() {
        DiscountResult discountResult = new DiscountResult();
        for (Event event : events) {
            String eventName = event.getEventName();
            int discountAmount = event.calculateDiscount() * -1;
            discountResult.addDiscount(eventName, discountAmount);
        }
        return discountResult;
    }
}
