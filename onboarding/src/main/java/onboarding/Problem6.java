package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> newForm = getNewForm(forms);
        Set<String> nickNameTwo = getNickNameTwoSet(forms);
        Map<String, Integer> map = getSubStringCountMap(newForm, nickNameTwo);
        Set<String> duplicatedSubStrings = getDuplicatedSubStrings(map);

        for (Map.Entry<String, String> entry : newForm.entrySet()) {
            for (String subString : duplicatedSubStrings) {
                if(entry.getKey().contains(subString)) {
                    answer.add(entry.getValue());
                }
            }
        }
        answer.sort(Comparator.naturalOrder());

        return answer;
    }

    /**
     * substring이 몇번 나왔는지 key: SubString, value: count을 가진 Map 리턴해주는 함수
     */
    private static Map<String, Integer> getSubStringCountMap(Map<String, String> newForm, Set<String> nickNameTwo) {
        Map<String, Integer> map = new HashMap<>();
        for (String nickName : newForm.keySet()) {
            for (String nickNameSubString : nickNameTwo) {
                if(nickName.contains(nickNameSubString)) {
                    map.put(nickNameSubString, map.getOrDefault(nickNameSubString,0) + 1);
                }
            }
        }
        return map;
    }

    /**
     * 중복된 SubString(value > 1) Set 리턴해주는 함수
     */
    private static Set<String> getDuplicatedSubStrings(Map<String, Integer> map) {
        Set<String> duplicatedSubStrings = new HashSet<>();
        for (Map.Entry<String, Integer> subStrings : map.entrySet()) {
            if(subStrings.getValue() > 1) {
                duplicatedSubStrings.add(subStrings.getKey());
            }
        }
        return duplicatedSubStrings;
    }

    /**
     * List -> Map(key: 닉네임, value: 이메일) 으로 변환하는 함수
     */
    private static Map<String, String> getNewForm(List<List<String>> forms) {
        Map<String, String> newForm = new HashMap<>();
        for (List<String> form : forms) {
            newForm.put(form.get(1), form.get(0));
        }
        return newForm;
    }

    /**
     * 이메일 형식 검증하는 함수
     */
    public static boolean isVaildEmail(String email) {
        String emailPattern = "\\w{1,10}@email\\.com";
        return Pattern.matches(emailPattern, email);
    }

    /**
     * 닉네임 형식 검증하는 함수
     */
    public static boolean isVaildNickName(String nickName) {
        String nickNamePattern = "^[ㄱ-ㅎ가-힣]{1,19}$";
        return Pattern.matches(nickNamePattern, nickName);
    }

    /**
     *  닉네임을 두글자씩 쪼게서 Set에 넣는 함수
     */
    public static Set<String> getNickNameTwoSet(List<List<String>> forms) {

        Set<String> st = new HashSet<>();
        for (List<String> form : forms) {
            String nickName = form.get(1);
            for (int i = 0; i < nickName.length() - 1; i++) {
                st.add(nickName.substring(i, i + 2));
            }
        }
        return st;
    }

}
