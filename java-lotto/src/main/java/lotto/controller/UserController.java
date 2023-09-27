package lotto.controller;

import lotto.model.User;
import camp.nextstep.edu.missionutils.Console;

public class UserController {

    private User user;

    public UserController() {
        this.user = new User();
    }

    public void playLotto() {
        purchase();
        user.printLotto();
        inputWinningNumber();
        user.checkWinning();
        user.printResult();
        user.getRate();
    }

    private void purchase() {
        System.out.println("구입금액 입력 해주세요");
        user.setLottoList(Integer.parseInt(Console.readLine())); //NullFormat 예외처리해야함
    }

    private void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요");
        user.setWinningLotto(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요");
        user.setBonusNumber(Integer.parseInt(Console.readLine()));
    }

}
