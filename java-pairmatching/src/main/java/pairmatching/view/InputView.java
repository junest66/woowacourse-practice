package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static final String FUNCTION_PROMPT = "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";

    public static final String COURSE_INFO_PROMPT = "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";

    public static final String REMATCHING_PROMPT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";

    public String readFunction() {
        System.out.println(FUNCTION_PROMPT);
        return readLine();
    }

    public String readCourseInfo() {
        System.out.println(COURSE_INFO_PROMPT);
        return readLine();
    }

    public String readReMatching() {
        System.out.println(REMATCHING_PROMPT);
        return readLine();
    }
}
