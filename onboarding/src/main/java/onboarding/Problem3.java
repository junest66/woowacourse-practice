package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = getAnswerNumber(number);
        return answer;
    }

    /**
     * 손뼉 갯수 세는 함수
     */
    public static int getAnswerNumber(int number) {
        int count = 0;
        for(int i = 1; i <= number; i++) {
            count += checkNumber(i);
        }
        return count;
    }

    /**
     * 손뼉을 몇번 쳐야하는지 세는 함수
     */
    public static int checkNumber(int number) {
        int threeNum = 0;
        int sixNum = 0;
        int nineNum = 0;
        String str = Integer.toString(number);
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '3') {
                threeNum++;
            }
            if(str.charAt(i) == '6') {
                sixNum++;
            }
            if(str.charAt(i) == '9') {
                nineNum++;
            }
        }
        return threeNum + sixNum + nineNum;
    }
}
