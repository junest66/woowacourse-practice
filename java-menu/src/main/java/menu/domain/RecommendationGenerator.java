package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.constants.FoodCategory;
import menu.constants.FoodMenu;

public class RecommendationGenerator {
    private static final int MIN_CATEGORY_NUMBER = 1;
    private static final int MAX_CATEGORY_NUMBER = 5;

    public FoodCategory getRandomCategory() {
        int randomNumber = Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER, MAX_CATEGORY_NUMBER);
        return FoodCategory.findByNumber(randomNumber);
    }

    public String generateRecommendation(Coach coach, FoodCategory category, Map<Coach, List<String>> result) {
        List<String> eligibleMenus = getEligibleMenus(category);
        String recommendFood;
        do {
            recommendFood = Randoms.shuffle(eligibleMenus).get(0);
        } while (isMenuNotRecommendedOrAlreadyRecommended(coach, recommendFood, result));
        return recommendFood;
    }

    private boolean isMenuNotRecommendedOrAlreadyRecommended(Coach coach, String menu,
                                                             Map<Coach, List<String>> result) {
        List<String> recommendedMenus = result.getOrDefault(coach, new ArrayList<>());
        return coach.isMenuEligible(menu) || recommendedMenus.contains(menu);
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
