package menu.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {
    @Test
    @DisplayName("먹을 수 있는 메뉴인 경우 테스트")
    public void testIsMenuEligibleWithEligibleMenu() {
        List<String> ineligibleFoods = Arrays.asList("초밥", "라면");
        Coach coach = new Coach("존", ineligibleFoods);
        String eligibleMenu = "비빔밥";
        boolean isEligible = coach.isMenuEligible(eligibleMenu);
        assertTrue(isEligible, "해당 메뉴는 먹을 수 있어야 합니다.");
    }

    @Test
    @DisplayName("먹을 수 없는 메뉴인 경우 테스트")
    public void testIsMenuEligibleWithIneligibleMenu() {
        List<String> ineligibleFoods = Arrays.asList("초밥", "라면");
        Coach coach = new Coach("앨리스", ineligibleFoods);
        String ineligibleMenu = "초밥";
        boolean isEligible = coach.isMenuEligible(ineligibleMenu);
        assertFalse(isEligible, "해당 메뉴는 먹을 수 없어야 합니다.");
    }
}
