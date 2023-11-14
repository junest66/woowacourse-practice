package controller;

import christmas.DTO.DiscountResultDTO;
import christmas.DTO.OrderDTO;
import christmas.domain.BadgeCalculator;
import christmas.domain.DiscountCalculator;
import christmas.domain.DiscountResult;
import christmas.domain.EventsFactory;
import christmas.domain.Order;
import christmas.domain.PaymentAmountCalculator;
import christmas.domain.Waiter;
import christmas.domain.event.Event;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.Map;

public class EventPlannerController {

    private Order order;
    private OutputView outputView;
    private InputView inputView;
    private Waiter waiter;
    private DiscountCalculator discountCalculator;
    private DiscountResult discountResult;
    private PaymentAmountCalculator paymentCalculator;
    private BadgeCalculator badgeCalculator;

    public EventPlannerController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.waiter = new Waiter();
        this.paymentCalculator = new PaymentAmountCalculator();
        this.badgeCalculator = new BadgeCalculator();
    }

    public void start() {
        outputView.printEventStartGreeting();
        order = processOrder();
        outputView.printOrderInformation(new OrderDTO(order));
        outputView.printTotalOrderAmountBeforeDiscount(order.calculateTotalPriceBeforeDiscount());
        List<Event> events = new EventsFactory(order).createEvents();
        discountCalculator = new DiscountCalculator(events);
        discountResult = discountCalculator.calculateDiscount();
        outputView.printGiveawayMenu(discountResult.getGiveawayMenu());
        outputView.printDiscountResult(new DiscountResultDTO(discountResult));
        outputView.printTotalDiscountAmount(discountResult.getTotalAllDiscountAmount());
        int paymentAmount = paymentCalculator.calculatePaymentAmount(order, discountResult);
        outputView.printPaymentAmountAfterDiscount(paymentAmount);
        outputView.printBadgeResult(badgeCalculator.calculateBadge(discountResult));
    }

    private Order processOrder() {
        int date = inputView.getDecemberDay();
        while (true) {
            Map<String, Integer> menuOrder = inputView.getMenuOrder();
            try {
                return waiter.takeOrder(date, menuOrder);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
