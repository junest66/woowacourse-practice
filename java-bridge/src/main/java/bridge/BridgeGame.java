package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> currentUpMap;
    private List<String> currentDownMap;
    private boolean gameStatus;

    public BridgeGame() {
        this.gameStatus = true;
        this.currentUpMap = new ArrayList<>();
        this.currentDownMap = new ArrayList<>();
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(boolean result, String input) {
        if(result) {
            successTurn(input);
        }
        if(!result) {
            failTurn(input);
        }

    }

    public void successTurn(String input) {
        if (input.equals("U")) {
            currentUpMap.add("O");
            currentDownMap.add(" ");
        }
        if (input.equals("D")) {
            currentDownMap.add("O");
            currentUpMap.add(" ");
        }
    }

    public void failTurn(String input) {
        if (input.equals("U")) {
            currentUpMap.add("X");
            currentDownMap.add(" ");
        }
        if (input.equals("D")) {
            currentDownMap.add("X");
            currentUpMap.add(" ");
        }
    }



    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.gameStatus = false;
    }

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public List<String> getCurrentUpMap() {
        return currentUpMap;
    }

    public List<String> getCurrentDownMap() {
        return currentDownMap;
    }

    public void initCurrentMap() {
        this.currentUpMap = new ArrayList<>();
        this.currentDownMap = new ArrayList<>();
    }
}
