package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.constants.DayOfWeek;
import menu.constants.FoodCategory;

public class ResultRecommendMenu {
    private final Map<Coach, List<String>> result = new LinkedHashMap<>();
    private final List<FoodCategory> recommendedCategories = new ArrayList<>();
    private final RecommendationGenerator recommendationGenerator;

    public ResultRecommendMenu(RecommendationGenerator recommendationGenerator) {
        this.recommendationGenerator = recommendationGenerator;
    }

    public void recommend(List<Coach> coaches) {
        for (int count = 0; count < DayOfWeek.values().length; count++) {
            FoodCategory randomCategory = recommendationGenerator.getRandomCategory();
            recommendedCategories.add(randomCategory);
            generateRecommendationsForCategory(coaches, recommendationGenerator, randomCategory);
        }
    }

    private void generateRecommendationsForCategory(List<Coach> coaches, RecommendationGenerator generator,
                                                    FoodCategory category) {
        for (Coach coach : coaches) {
            String recommendedMenu = generator.generateRecommendation(coach, category, result);
            result.computeIfAbsent(coach, k -> new ArrayList<>()).add(recommendedMenu);
        }
    }

    public Map<Coach, List<String>> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public List<FoodCategory> getRecommendedCategories() {
        return Collections.unmodifiableList(recommendedCategories);
    }
}
