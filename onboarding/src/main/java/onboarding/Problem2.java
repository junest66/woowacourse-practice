package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String init = cryptogram;
        while (!checkDuplicate(init)) {
            init = removeDuplicates(init);
        }
        answer = init;
        return answer;
    }


    /**
     * 연속하는 문자열의 중복 체크하는 함수
     */
    public static boolean checkDuplicate(String str) {
        Boolean init = true;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                init = false;
            }
        }

        return init;
    }

    /**
     * 중복을 제거하는 함수
     */
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(indexCheckDuplicates(str,i)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 인덱스 기준으로 중복 확인하는 함수
     */
    public static boolean indexCheckDuplicates(String str, int index) {
        char indexChar = str.charAt(index);

        if (index == 0) {
            return indexChar != str.charAt(index + 1);
        }

        if (index == str.length() - 1) {
            return indexChar != str.charAt(index - 1);
        }

        return indexChar != str.charAt(index - 1) && indexChar != str.charAt(index + 1);
    }

}
