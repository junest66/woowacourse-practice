package controller;

import christmas.DTO.DiscountResultDTO;
import christmas.DTO.OrderDTO;
import christmas.domain.BadgeCalculator;
import christmas.domain.DiscountCalculator;
import christmas.domain.DiscountResult;
import christmas.domain.Order;
import christmas.domain.PaymentAmountCalculator;
import christmas.domain.Waiter;
import christmas.domain.event.ChristmasDiscountEvent;
import christmas.domain.event.DayOfWeekDiscountEvent;
import christmas.domain.event.Event;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.event.SpecialDiscountEvent;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderController {

    private Order order;
    private OutputView outputView;
    private InputView inputView;
    private Waiter waiter;
    private DiscountCalculator discountCalculator;
    private DiscountResult discountResult;
    private PaymentAmountCalculator paymentCalculator;
    private BadgeCalculator badgeCalculator;

    public OrderController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.waiter = new Waiter();
        this.paymentCalculator = new PaymentAmountCalculator();
        this.badgeCalculator = new BadgeCalculator();
    }

    public void start() {
        outputView.printEventStartGreeting();
        processOrder();
        outputView.printOrderInformation(new OrderDTO(order));
        outputView.printTotalOrderAmountBeforeDiscount(order.calculateTotalPriceBeforeDiscount());
        initializeDiscountEvents();
        discountResult = discountCalculator.calculateDiscount();
        outputView.printGiveawayMenu(discountResult.getGiveawayMenu());
        outputView.printDiscountResult(new DiscountResultDTO(discountResult));
        outputView.printTotalDiscountAmount(discountResult.getTotalAllDiscountAmount());
        int paymentAmount = paymentCalculator.calculatePaymentAmount(order, discountResult);
        outputView.printPaymentAmountAfterDiscount(paymentAmount);
        outputView.printBadgeResult(badgeCalculator.calculateBadge(discountResult));
    }

    private void processOrder() {
        int date = inputView.getDecemberDay();
        while (true) {
            Map<String, Integer> menuOrder = inputView.getMenuOrder();
            try {
                order = waiter.takeOrder(date, menuOrder);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void initializeDiscountEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new ChristmasDiscountEvent(order));
        events.add(new DayOfWeekDiscountEvent(order));
        events.add(new SpecialDiscountEvent(order));
        events.add(new GiveawayEvent(order));
        discountCalculator = new DiscountCalculator(events);
    }
}
