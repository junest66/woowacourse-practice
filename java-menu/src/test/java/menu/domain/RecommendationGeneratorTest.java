package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.constants.FoodCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecommendationGeneratorTest {

    private RecommendationGenerator recommendationGenerator;

    @BeforeEach
    void setUp() {
        recommendationGenerator = new RecommendationGenerator(new FakeRandomGenerator());
    }

    @Test
    void getRandomCategory() {
        FoodCategory randomCategory = recommendationGenerator.getRandomCategory();
        assertThat(randomCategory).isEqualTo(FoodCategory.findByNumber(1));
    }

    @Test
    void generateRecommendation() {
        Coach coach = new Coach("토미", new ArrayList<>());
        Map<Coach, List<String>> result = new LinkedHashMap<>();
        String recommendation = recommendationGenerator.generateRecommendation(coach, FoodCategory.JAPANESE, result);

        assertThat(recommendation).isEqualTo("규동");
    }
}
