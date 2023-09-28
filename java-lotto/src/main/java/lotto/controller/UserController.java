package lotto.controller;

import lotto.constant.ErrorOutputMessage;
import lotto.model.User;
import camp.nextstep.edu.missionutils.Console;

public class UserController {

    private User user;

    public UserController() {
        this.user = new User();
    }

    public void playLotto() {
        try {
            purchase();
            user.printLotto();
            inputWinningNumber();
            user.checkWinning();
            user.printResult();
            user.getRate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void purchase() {
        System.out.println("구입금액 입력 해주세요");
        try {
            user.setLottoList(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorOutputMessage.PURCHASE_TYPE);
        }
    }

    private void inputWinningNumber() {
        try {
            System.out.println("당첨 번호를 입력해 주세요");
            user.setWinningLotto(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorOutputMessage.PURCHASE_TYPE);
        }
        System.out.println("보너스 번호를 입력해 주세요");
        user.setBonusNumber(Integer.parseInt(Console.readLine()));
    }
}
