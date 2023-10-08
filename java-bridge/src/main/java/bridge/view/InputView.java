package bridge.view;

import bridge.validator.InputBridgeSizeValidator;
import bridge.validator.MovingBridgeValidator;
import bridge.validator.RestartValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize;
        while (true) {
            outputView.printInputBridge();
            String inputSize = Console.readLine();
            try {
                bridgeSize = InputBridgeSizeValidator.validateBridgeSizeFormat(inputSize);
                InputBridgeSizeValidator.validateBridgeSizeRange(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                continue;
            }
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputMoving = "";
        while (true) {
            outputView.printMoveBridge();
            inputMoving = Console.readLine();
            try {
                MovingBridgeValidator.validatorInputMovingBridge(inputMoving);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                continue;
            }
        }
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String restart = "";
        while (true) {
            outputView.printGameRestart();
            restart = Console.readLine();
            try {
                RestartValidator.validatorInputRestart(restart);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                continue;
            }
        }
        return restart;
    }
}
