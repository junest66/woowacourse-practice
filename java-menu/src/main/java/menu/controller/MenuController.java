package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.ResultRecommendMenu;
import menu.utils.InputProcessor;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final InputProcessor inputProcessor = new InputProcessor();
    private final ResultRecommendMenu resultRecommendMenu = new ResultRecommendMenu();

    public void run() {
        List<String> names = getCoachNames();
        List<Coach> coaches = getCoachesWithRestrictedMenus(names);
        resultRecommendMenu.recommend(coaches);
        outputView.printRecommendResult(resultRecommendMenu.getResult(),
                resultRecommendMenu.getRecommendedCategories());
    }

    private List<String> getCoachNames() {
        outputView.printServiceStartMessage();
        while (true) {
            try {
                String input = inputView.readCoachNames();
                return inputProcessor.processCoachNames(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Coach> getCoachesWithRestrictedMenus(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            Coach coach = createCoachWithRestrictedMenus(coachName);
            if (coach != null) {
                coaches.add(coach);
            }
        }
        return coaches;
    }

    private Coach createCoachWithRestrictedMenus(String coachName) {
        while (true) {
            try {
                String restrictedMenusInput = inputView.readRestrictedMenu(coachName);
                List<String> restrictedMenus = inputProcessor.processRestrictedMenus(restrictedMenusInput);
                return new Coach(coachName, restrictedMenus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
