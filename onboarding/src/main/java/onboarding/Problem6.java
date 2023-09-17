package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 이메일 형식 검증하는 함수
     */
    public static boolean isVaildEmail(String email) {
        String emailPattern = "\\w{1,10}@email\\.com";
        return Pattern.matches(emailPattern, email);
    }
}
