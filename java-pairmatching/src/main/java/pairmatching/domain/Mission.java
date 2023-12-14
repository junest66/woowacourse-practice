package pairmatching.domain;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    SHOPPING_CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY_MAP("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DEPLOYMENT("배포");

    private final String name;

    private static final String ERROR_INVALID_MISSION_NAME = "[ERROR] 유효하지 않은 미션 이름입니다. 다시 입력해주세요.";

    Mission(String name) {
        this.name = name;
    }

    public static Mission getConstants(String input) {
        for (Mission mission : Mission.values()) {
            if (mission.getName().equalsIgnoreCase(input)) {
                return mission;
            }
        }
        throw new IllegalArgumentException(ERROR_INVALID_MISSION_NAME);
    }

    public String getName() {
        return name;
    }
}
