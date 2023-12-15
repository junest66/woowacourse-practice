package christmas.view;

public class OutputView {
    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printOrderInfo(int day, String menuOrder) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
        System.out.println(menuOrder);
        System.out.println();
    }

    public void printTotalOrderAmount(int totalAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatAmount(totalAmount));
        System.out.println();
    }

    public void printGiveawayMenu(String menu) {
        System.out.println("<증정 메뉴>");
        System.out.println(menu);
        System.out.println();
    }

    public void printBenefitResult(String result) {
        System.out.println("<혜택 내역>");
        System.out.println(result);
        System.out.println();
    }

    public void printTotalBenefitAmount(int amount) {
        System.out.println("<총혜택 금액>");
        System.out.println(formatAmount(amount));
        System.out.println();
    }

    public void printPaymentAmount(int amount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(formatAmount(amount));
        System.out.println();
    }

    public void printBadge(String name) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(name);
        System.out.println();
    }

    private String formatAmount(int amount) {
        return String.format("%,d원", amount);
    }
}
