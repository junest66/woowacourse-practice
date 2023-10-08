package bridge.validator;

public class MovingBridgeValidator {

    public static final String UP_STRING = "U";
    public static final String DOWN_STRING = "D";
    public static final String BRIDGE_MOVING_INPUT_ERROR = "[ERROR] (위: U, 아래: D) 중에 입력해야합니다.";

    public static final void validatorInputMovingBridge(String input) {
        if(!(input.equals(UP_STRING) || input.equals(DOWN_STRING))) {
            throw new IllegalArgumentException(BRIDGE_MOVING_INPUT_ERROR);
        }
    }

}
