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

    public void setBolNum(int bolNum) {
        this.bolNum = bolNum;
    }

    public int getStrikeNum() {
        return strikeNum;
    }

    public void setStrikeNum(int strikeNum) {
        this.strikeNum = strikeNum;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Referee() {
        this.bolNum = 0;
        this.strikeNum = 0;
        this.success = false;
    }

    public void judge(List<Integer> user, List<Integer> computer) {

        System.out.println("user.toString() = " + user.toString());
        System.out.println("computer = " + computer.toString());
        //같은자리애 같은수 (스트라이크)
        int strike = 0;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        System.out.println("strike = " + strike);
        setStrikeNum(strike);

        //Set ( 볼 + 스트라이크 )
        Set setUser = new HashSet<>(user);
        Set setComputer = new HashSet<>(computer);
        setUser.retainAll(setComputer);

        //Set - 같은자리에 같은수 (볼)
        setBolNum(setUser.size() - strike);
        System.out.println("setUser size = " + setUser.size());
    }

    public void print() {
        if (strikeNum == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            success = true;
        } else if (bolNum > 0) {
            System.out.println(bolNum + "볼");
        } else if (strikeNum > 0) {
            System.out.println(strikeNum + "스트라이크");
        } else if (bolNum == 0 && strikeNum == 0) {
            System.out.println("낫싱");
        }
    }
}
