package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> myFriends = getRelationShipMap(friends);
        Map<String, Integer> score = getStringIntegerMap(user, myFriends);

        getVisitorScore(visitors, score);

        List<Map.Entry<String, Integer>> sortedEntries = getRecommendList(user, myFriends, score);
        getSortedList(sortedEntries);
        for (Map.Entry<String, Integer> sortedEntry : sortedEntries) {
            answer.add(sortedEntry.getKey());
        }
        return answer;
    }

    /**
     * 출력에 맞춰 정렬하는 함수
     */
    private static void getSortedList(List<Map.Entry<String, Integer>> sortedEntries) {
        Collections.sort(sortedEntries, (entry1, entry2) -> {
            int result = entry2.getValue().compareTo(entry1.getValue()); // 내림차순
            if (result == 0) {
                // 값이 같으면 키를 오름차순으로 정렬
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return result;
        });
    }

    /**
     * 최종적으로 추천할 리스트 생성하는 함수
     */
    private static List<Map.Entry<String, Integer>> getRecommendList(String user, Map<String, List<String>> myFriends, Map<String, Integer> score) {
        List<Map.Entry<String, Integer>> recommandList = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : score.entrySet()) {
            List<String> userFriends = myFriends.get(user);
            if(userFriends.contains(stringIntegerEntry.getKey())) continue;
            if(stringIntegerEntry.getValue() == 0) continue;
            recommandList.add(stringIntegerEntry);
        }
        return recommandList;
    }

    /**
     * 방문자수 점수 계산하는 함수
     */
    private static void getVisitorScore(List<String> visitors, Map<String, Integer> score) {
        for (String visitor : visitors) {
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }
    }

    /**
     * 사용자와 함께 아는 친구 점수 계산 해서 score Map 생성하는 함수
     */
    private static Map<String, Integer> getStringIntegerMap(String user, Map<String, List<String>> myFriends) {
        Map<String, Integer> score = new HashMap<>();
        List<String> userFriends = myFriends.get(user);

        for (Map.Entry<String, List<String>> entry : myFriends.entrySet()) {
            if(entry.getKey().equals(user)) {
                continue;
            }
            List<String> compareList = entry.getValue();
            compareList.retainAll(userFriends);
            score.put(entry.getKey(), compareList.size() * 10);
        }
        return score;
    }

    /**
     * 친구 관계 map 생성
     */
    private static Map<String, List<String>> getRelationShipMap(List<List<String>> friends) {
        Map<String, List<String>> myFriends = new HashMap<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            myFriends.putIfAbsent(friend1, new ArrayList<>());
            myFriends.putIfAbsent(friend2, new ArrayList<>());
            myFriends.get(friend1).add(friend2);
            myFriends.get(friend2).add(friend1);
        }
        return myFriends;
    }

}
