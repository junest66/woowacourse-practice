package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pair {
    private List<Crew> crewMembers;

    public Pair() {
        this.crewMembers = new ArrayList<>();
    }

    public void addCrew(Crew crew) {
        crewMembers.add(crew);
    }

    public List<Crew> getCrewMembers() {
        return crewMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return Objects.equals(crewMembers, pair.crewMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crewMembers);
    }

    @Override
    public String toString() {
        return crewMembers.stream()
                .map(Crew::getName)
                .reduce((a, b) -> a + " : " + b)
                .orElse("");
    }
}
