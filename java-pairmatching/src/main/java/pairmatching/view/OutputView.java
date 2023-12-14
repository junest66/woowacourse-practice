package pairmatching.view;

import java.util.List;
import java.util.Set;
import pairmatching.domain.Pair;

public class OutputView {
    public static final String COURSE_INFO = "#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: \n"
            + "############################################";

    public static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
    public static final String NO_PAIRING_HISTORY_ERROR = "[ERROR] 매칭 이력이 없습니다.";
    public static final String RESET_MESSAGE = "초기화 되었습니다.";

    public void printCourseInfo() {
        System.out.println(COURSE_INFO);
    }

    public void showPairingResult(List<Pair> pairs) {
        System.out.println(PAIR_MATCHING_RESULT);
        for (Pair pair : pairs) {
            System.out.println(pair);
        }
    }

    public void showPairingInfo(Set<Pair> pairs) {
        System.out.println(PAIR_MATCHING_RESULT);
        for (Pair pair : pairs) {
            System.out.println(pair);
        }
    }

    public void showNoPairingHistoryMessage() {
        System.out.println(NO_PAIRING_HISTORY_ERROR);
    }

    public void printResetMessage() {
        System.out.println(RESET_MESSAGE);
    }
}

