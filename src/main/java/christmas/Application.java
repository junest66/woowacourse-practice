package christmas;

import controller.OrderController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OrderController orderController = new OrderController();
        orderController.start();
    }
}
