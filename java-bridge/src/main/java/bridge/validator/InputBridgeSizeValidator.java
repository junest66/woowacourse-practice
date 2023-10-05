package bridge.validator;

public class InputBridgeSizeValidator {

    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;

    public static final String BRIDGE_SIZE_FORMAT_ERROR = "[ERROR] 숫자를 입력해야합니다.";
    public static final String BRIDGE_SIZE_RANGE_ERROR =
        "[ERROR] 다리 길이는 " + MINIMUM_BRIDGE_SIZE + "부터 " + MAXIMUM_BRIDGE_SIZE + "사이의 숫자여야 합니다.";

    public static int validateBridgeSizeFormat(String inputSize) {
        try {
            return Integer.parseInt(inputSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_FORMAT_ERROR);
        }
    }

    public static void validateBridgeSizeRange(int inputSize) {
        if (inputSize < MINIMUM_BRIDGE_SIZE || inputSize > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR);
        }
    }

}
