package lotto;

import lotto.controller.UserController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserController userController = new UserController();
        userController.playLotto();
    }
}
