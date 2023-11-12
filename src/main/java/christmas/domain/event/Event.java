package christmas.domain.event;

public interface Event {
    boolean isNotApplicable();

    int calculateDiscount();

    String getEventName();
}
