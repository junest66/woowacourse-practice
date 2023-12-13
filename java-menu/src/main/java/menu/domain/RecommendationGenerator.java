package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.constants.FoodCategory;
import menu.constants.FoodMenu;
import menu.utils.RandomGenerator;

public class RecommendationGenerator {
    private final RandomGenerator randomGenerator;

    public RecommendationGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public FoodCategory getRandomCategory() {
        int randomNumber = randomGenerator.generateRandomNumberInRange();
        return FoodCategory.findByNumber(randomNumber);
    }

    public String generateRecommendation(Coach coach, FoodCategory category, Map<Coach, List<String>> result) {
        List<String> eligibleMenus = getEligibleMenus(category);
        String recommendFood;
        do {
            recommendFood = (String) randomGenerator.getRandomItem(eligibleMenus);
        } while (isMenuNotRecommendedOrAlreadyRecommended(coach, recommendFood, result));
        return recommendFood;
    }

    private boolean isMenuNotRecommendedOrAlreadyRecommended(Coach coach, String menu,
                                                             Map<Coach, List<String>> result) {
        List<String> recommendedMenus = result.getOrDefault(coach, new ArrayList<>());
        return !coach.isMenuEligible(menu) || recommendedMenus.contains(menu);
    }

    private List<String> getEligibleMenus(FoodCategory category) {
        List<String> eligibleMenus = new ArrayList<>();
        for (FoodMenu menu : FoodMenu.values()) {
            if (menu.getCategory() == category) {
                eligibleMenus.add(menu.getName());
            }
        }
        return eligibleMenus;
    }
}
