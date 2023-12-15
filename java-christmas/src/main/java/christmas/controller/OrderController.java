package christmas.controller;

import christmas.domain.EventManager;
import christmas.domain.MenuOrder;
import christmas.utils.InputProcessor;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class OrderController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        outputView.printStartMessage();
        int day = getVisitDay();
        MenuOrder menuOrder = getMenuOrder();
        outputView.printOrderInfo(day, menuOrder.toString());
        outputView.printTotalOrderAmount(menuOrder.calculateTotalPrice());
        EventManager eventManager = new EventManager(day, menuOrder);
        printResult(eventManager);
    }

    private int getVisitDay() {
        while(true) {
            try {
                String visitDay = inputView.readVisitDay();
                return InputProcessor.processVisitDay(visitDay);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private MenuOrder getMenuOrder() {
        while(true) {
            try {
                String order = inputView.readOrder();
                Map<String, Integer> menuOrder = InputProcessor.processOrder(order);
                return new MenuOrder(menuOrder);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResult(EventManager eventManager) {
        outputView.printGiveawayMenu(eventManager.getGiveawayMenu());
        outputView.printBenefitResult(eventManager.toString());
        outputView.printTotalBenefitAmount(eventManager.getTotalBenefitAmount());
        outputView.printPaymentAmount(eventManager.getPaymentAmount());
        outputView.printBadge(eventManager.getBadgeName());
    }
}
