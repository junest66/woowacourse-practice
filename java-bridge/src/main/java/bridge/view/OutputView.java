package bridge.view;

import bridge.BridgeGame;
import bridge.Message;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upMap, List<String> downMap) {
        if (upMap.size() == 1) {
            System.out.println("[ " + upMap.get(0) + " ]");
            System.out.println("[ " + downMap.get(0) + " ]");
            return;
        }
        String upResult = String.join(" | ", upMap);
        String downResult = String.join(" | ", downMap);
        System.out.println("[ " + upResult + " ]");
        System.out.println("[ " + downResult + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int currentCount, BridgeGame bridgeGame, String gameResult) {
        System.out.println();
        System.out.println(Message.RESULT_GAME_MESSAGE);
        printMap(bridgeGame.getCurrentUpMap(), bridgeGame.getCurrentDownMap());
        System.out.println();
        System.out.println(Message.GAME_SUCCESS_STATUS + gameResult);
        System.out.println(Message.TOTAL_GAME_NUMBER + currentCount);
    }

    public void printStart() {
        System.out.println(Message.START_PRINT);
        System.out.println();
    }

    public void printInputBridge() {
        System.out.println(Message.INPUT_BRIDGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printMoveBridge() {
        System.out.println();
        System.out.println(Message.MOVE_BRIDGE);
    }

    public void printGameRestart() {
        System.out.println(Message.GAME_RESTART);
    }
}
