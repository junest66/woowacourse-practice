package pairmatching.domain;

public enum Level {
    LEVEL1("레벨1"), LEVEL2("레벨2"), LEVEL3("레벨3"), LEVEL4("레벨4"), LEVEL5("레벨5");

    private String name;
    private static final String ERROR_INVALID_LEVEL_NAME = "[ERROR] 유효하지 않은 레벨 이름입니다. 다시 입력해주세요.";

    Level(String name) {
        this.name = name;
    }

    public static Level getConstants(String input) {
        for (Level level : Level.values()) {
            if (level.getName().equalsIgnoreCase(input)) {
                return level;
            }
        }
        throw new IllegalArgumentException(ERROR_INVALID_LEVEL_NAME);
    }

    public String getName() {
        return name;
    }
}
