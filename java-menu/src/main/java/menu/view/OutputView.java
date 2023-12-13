package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.constants.DayOfWeek;
import menu.constants.FoodCategory;
import menu.domain.Coach;

public class OutputView {
    private static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String MENU_RECOMMENDATION_RESULT = "메뉴 추천 결과입니다.";
    private static final String CATEGORY_LABEL = "카테고리";
    private static final String SEPARATOR = " | ";
    private static final String COMPLETE_MESSAGE = "추천을 완료했습니다.";
    private static final String HEADER_FORMAT = "[ %s ]";
    private static final String COACH_LABEL = "구분";

    public void printServiceStartMessage() {
        System.out.println(SERVICE_START_MESSAGE);
    }

    public void printRecommendResult(Map<Coach, List<String>> result, List<FoodCategory> foodCategories) {
        System.out.println();
        printHeader();
        printCategoryHeader(foodCategories);
        printCoachRecommendations(result);
        System.out.println();
        System.out.print(COMPLETE_MESSAGE);
    }

    private void printHeader() {
        System.out.println(MENU_RECOMMENDATION_RESULT);
        DayOfWeek[] daysOfWeek = DayOfWeek.values();
        List<String> header = new ArrayList<>();
        header.add(COACH_LABEL);
        for (DayOfWeek day : daysOfWeek) {
            header.add(day.getName());
        }
        System.out.println(String.format(HEADER_FORMAT, String.join(SEPARATOR, header)));
    }

    private void printCategoryHeader(List<FoodCategory> foodCategories) {
        List<String> categoryList = new ArrayList<>();
        categoryList.add(CATEGORY_LABEL);
        for (FoodCategory category : foodCategories) {
            categoryList.add(category.getName());
        }
        System.out.println(String.format(HEADER_FORMAT, String.join(SEPARATOR, categoryList)));
    }

    private void printCoachRecommendations(Map<Coach, List<String>> result) {
        for (Coach coach : result.keySet()) {
            List<String> coachRow = new ArrayList<>();
            coachRow.add(coach.getName());
            List<String> recommendedMenus = result.get(coach);
            coachRow.addAll(recommendedMenus);
            System.out.println(String.format(HEADER_FORMAT, String.join(SEPARATOR, coachRow)));
        }
    }
}
