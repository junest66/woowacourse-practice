package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events;
    private MenuOrder menuOrder;

    public EventManager(int day, MenuOrder menuOrder) {
        this.menuOrder = menuOrder;
        addTotalEvent(day, menuOrder);
    }

    private void addTotalEvent(int day, MenuOrder menuOrder) {
        events = new ArrayList<>();
        events.add(new ChristMasEvent(menuOrder, day));
        events.add(new WeeklyEvent(menuOrder, day));
        events.add(new SpecialEvent(menuOrder, day));
        events.add(new GiveawayEvent(menuOrder, day));
    }

    public String getGiveawayMenu() {
        if (events.get(3).getBenefitAmount() != 0) {
            return "샴폐인 1개";
        }
        return "없음";
    }

    public int getTotalBenefitAmount() {
        int sum = 0;
        for (Event event : events) {
            sum += event.getBenefitAmount();
        }
        return -1 * sum;
    }

    public int getPaymentAmount() {
        return menuOrder.calculateTotalPrice() + getTotalBenefitAmount() + events.get(3).getBenefitAmount();
    }

    public String getBadgeName() {
        return EventBadge.getByAmount(getTotalBenefitAmount() * -1).getKoreanName();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean hasBenefits = false;

        for (Event event : events) {
            if (event.getBenefitAmount() != 0) {
                hasBenefits = true;
                String formattedBenefit = String.format("%,d", Math.abs(event.getBenefitAmount()));
                sb.append(event.getEventName()).append(": -").append(formattedBenefit).append("원\n");
            }
        }

        if (!hasBenefits) {
            return "없음";
        }

        return sb.toString().trim();
    }
}
