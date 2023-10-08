package bridge.validator;

public class RestartValidator {

    public static final String RESTART = "R";
    public static final String QUIT = "Q";
    public static final String RESTART_ERROR = "[ERROR] (재시도: R, 종료: Q) 중에 입력해야합니다.";

    public static final void validatorInputRestart(String input) {
        if(!(input.equals(RESTART) || input.equals(QUIT))) {
            throw new IllegalArgumentException(RESTART_ERROR);
        }
    }

}
