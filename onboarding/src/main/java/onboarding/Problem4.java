package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<word.length(); i++) {
            sb.append(convertChar(word.charAt(i)));
        }
        answer = sb.toString();
        return answer;
    }

    /**
     * char 문자 변환 하는 함수
     */
    public static char convertChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('z' - (c - 'a'));
        }
        if (c >= 'A' && c <= 'Z') {
            return (char) ('Z' - (c - 'A'));
        }
        return c;
    }
}
