package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Referee {
    private int bolNum;
    private int strikeNum;
    private boolean success;

    public int getBolNum() {
        return bolNum;
    }

    public int getStrikeNum() {
        return strikeNum;
    }

    public boolean isSuccess() {
        return success;
    }

    public Referee() {
    }

    public void judge(List<Integer> user, List<Integer> computer) {
        init();

        for(int i = 0; i < user.size(); i++) {
            if(user.get(i).equals(computer.get(i))) {
                this.strikeNum++;
            } else if(computer.contains(user.get(i))) {
                this.bolNum++;
            }
        }
    }
    public void init() {
        this.bolNum = 0;
        this.strikeNum = 0;
        this.success = false;

    }

    public void print() {
        if (bolNum > 0) {
            System.out.print(bolNum + "볼 ");
        }
        if (strikeNum > 0) {
            System.out.print(strikeNum + "스트라이크");
        }
        if (bolNum == 0 && strikeNum == 0) {
            System.out.print("낫싱");
        }
        System.out.println("");

        if (strikeNum == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            success = true;
        }}
}
