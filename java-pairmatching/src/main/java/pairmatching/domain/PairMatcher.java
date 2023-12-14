package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PairMatcher {
    private static final String ERROR_UNABLE_TO_MATCH = "[ERROR] 페어 매칭에 실패했습니다. 최대 시도 횟수를 초과하였습니다.";

    private static final int MAX_ATTEMPT_COUNT = 3;

    private final PairingHistory pairingHistory;

    public PairMatcher(PairingHistory pairingHistory) {
        this.pairingHistory = pairingHistory;
    }

    public List<Pair> matchPairs(List<String> crewNames, EducationModule educationModule) {
        List<Pair> pairs;
        int attemptCount = 0;
        while (attemptCount < MAX_ATTEMPT_COUNT) {
            List<String> shuffledCrew = Randoms.shuffle(crewNames);
            pairs = createPairs(educationModule.getCourse(), shuffledCrew);
            if (isValidPairs(pairs, educationModule.getCourse(), educationModule.getLevel())) {
                addPairsToHistory(pairs, educationModule);
                return pairs;
            }
            attemptCount++;
        }
        throw new IllegalStateException(ERROR_UNABLE_TO_MATCH);
    }

    private void addPairsToHistory(List<Pair> pairs, EducationModule educationModule) {
        pairs.forEach(pair -> pairingHistory.addPair(educationModule.getCourse(), educationModule.getLevel(), pair));
    }

    private List<Pair> createPairs(Course course, List<String> shuffledCrew) {
        List<Pair> pairs = new ArrayList<>();
        int index = 0;
        int crewSize = shuffledCrew.size();

        while (index < crewSize) {
            Pair pair = createPair(course, shuffledCrew, index);
            pairs.add(pair);
            index += pair.getCrewMembers().size();
        }

        return pairs;
    }

    private Pair createPair(Course course, List<String> shuffledCrew, int startIndex) {
        Pair pair = new Pair();
        Crew firstCrew = new Crew(course, shuffledCrew.get(startIndex));
        pair.addCrew(firstCrew);

        if (startIndex + 1 < shuffledCrew.size()) {
            Crew secondCrew = new Crew(course, shuffledCrew.get(startIndex + 1));
            pair.addCrew(secondCrew);
        }

        return pair;
    }

    private boolean isValidPairs(List<Pair> pairs, Course course, Level level) {
        for (Pair pair : pairs) {
            if (pairingHistory.hasPairedBefore(course, level, pair)) {
                return false;
            }
        }
        return true;
    }
}
