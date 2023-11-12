package christmas.domain;

public class PaymentAmountCalculator {
    public int calculatePaymentAmount(Order order, DiscountResult discountResult) {
        int totalBeforeDiscount = order.calculateTotalPriceBeforeDiscount();
        int totalDiscount = discountResult.getTotalDiscountAmountExcludingGiveaway();
        return totalBeforeDiscount + totalDiscount;
    }
}
