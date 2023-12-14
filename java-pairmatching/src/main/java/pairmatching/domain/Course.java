package pairmatching.domain;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    private static final String ERROR_INVALID_COURSE_NAME = "[ERROR] 유효하지 않은 코스 이름입니다. 다시 입력해주세요.";

    Course(String name) {
        this.name = name;
    }

    public static Course getConstants(String input) {
        for (Course course : Course.values()) {
            if (course.getName().equalsIgnoreCase(input)) {
                return course;
            }
        }
        throw new IllegalArgumentException(ERROR_INVALID_COURSE_NAME);
    }

    public String getName() {
        return name;
    }
}
