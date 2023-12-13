package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final String COACH_NAME_PROMPT = "코치의 이름을 입력해 주세요. (" + SEPARATOR + " 로 구분)";
    private static final String RESTRICTED_MENU_PROMPT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String readCoachNames() {
        System.out.println();
        System.out.println(COACH_NAME_PROMPT);
        return Console.readLine();
    }

    public String readRestrictedMenu(String name) {
        System.out.println();
        System.out.printf(RESTRICTED_MENU_PROMPT, name);
        return Console.readLine();
    }
}
