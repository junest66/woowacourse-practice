package baseball.controller;

import baseball.model.Computer;
import baseball.model.Referee;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private Computer computer;
    private Referee referee;
    private User user;

    public GameController() {
        this.computer = new Computer();
        this.referee = new Referee();
        this.user = new User();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (user.getStartNumber().equals("1")) {
            init();
            turn();
        }
    }

    public void turn() {
        while (!referee.isSuccess()) {
            inputPlayerNumber();
            referee.judge(user.getNumbers(), computer.getRandomNumbers());
            referee.print();
        }
        restartGame();
    }

    public void inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        user.validation(input);
        user.setNumbers(user.inputNumber(input));
    }

    public void init() {
        computer.makeRandomNumbers();
        referee.init();
    }

    public void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        user.setStartNumber(input);
    }
}
