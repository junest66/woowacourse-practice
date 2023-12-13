package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> ineligibleFoods;

    public Coach(String name, List<String> ineligibleFoods) {
        this.name = name;
        this.ineligibleFoods = ineligibleFoods;
    }

    public boolean isMenuEligible(String menu) {
        return !ineligibleFoods.contains(menu);
    }

    public String getName() {
        return name;
    }
}
