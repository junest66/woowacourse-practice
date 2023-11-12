package christmas.domain;

import christmas.constants.Values;
import java.util.HashMap;
import java.util.Map;

public class DiscountResult {
    private Map<String, Integer> eventResult;

    public DiscountResult() {
        this.eventResult = new HashMap<>();
    }

    public void addDiscount(String eventName, int discountAmount) {
        eventResult.put(eventName, discountAmount);
    }

    public int getTotalAllDiscountAmount() {
        return eventResult.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getTotalDiscountAmountExcludingGiveaway() {
        return eventResult.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(Values.GIVEAWAY_EVENT_NAME))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public String getGiveawayMenu() {
        int giveawayDiscountAmount = eventResult.get(Values.GIVEAWAY_EVENT_NAME);
        if (giveawayDiscountAmount == 0) {
            return Values.NOT_EXIST;
        }
        return Values.GIVEAWAY_EVENT_ITEMS;
    }

    public Map<String, Integer> getEventResult() {
        return eventResult;
    }
}
