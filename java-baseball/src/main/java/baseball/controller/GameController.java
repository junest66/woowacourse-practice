package baseball.controller;

import baseball.model.Computer;
import baseball.model.Referee;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        do {
            initComputer();
            turn();
        } while (user.getStartNumber().equals("1"));
    }

    public void turn() {
        do {
            inputPlayerNumber();
            referee.judge(user.getNumbers(), computer.getRandomNumbers());
            referee.print();
        } while (!referee.isSuccess());
        restartGame();
    }

    public void inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        user.setNumbers(user.inputNumber());
    }

    public void initComputer() {
        this.computer = new Computer();
        this.referee = new Referee();
    }

    public void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        user.setStartNumber(input);
    }
}
