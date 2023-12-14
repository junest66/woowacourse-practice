package pairmatching.domain;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class PairingHistory {
    private Map<Course, Map<Level, Set<Pair>>> pairingHistory;

    public PairingHistory() {
        this.pairingHistory = new HashMap<>();
    }

    public void addPair(Course course, Level level, Pair pair) {
        pairingHistory.computeIfAbsent(course, k -> new HashMap<>())
                .computeIfAbsent(level, k -> new HashSet<>())
                .add(pair);
    }

    public boolean hasPairedBefore(Course course, Level level, Pair pair) {
        return pairingHistory.getOrDefault(course, new HashMap<>())
                .getOrDefault(level, new HashSet<>())
                .contains(pair);
    }

    public boolean hasPairing(Course course, Level level) {
        return pairingHistory.getOrDefault(course, new HashMap<>())
                .getOrDefault(level, new HashSet<>())
                .size() > 0;
    }

    public Set<Pair> getPairs(Course course, Level level) {
        return pairingHistory.getOrDefault(course, new HashMap<>())
                .getOrDefault(level, new HashSet<>());
    }

    public void clearPairs(Course course, Level level) {
        pairingHistory.getOrDefault(course, new HashMap<>())
                .remove(level);
    }

    public void clearAllPairs() {
        pairingHistory.clear();
    }
}
