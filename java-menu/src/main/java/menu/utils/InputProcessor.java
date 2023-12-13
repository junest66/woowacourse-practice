package menu.utils;

import java.util.Arrays;
import java.util.List;
import menu.validator.CoachNamesValidation;
import menu.validator.RestrictedMenuValidation;

public class InputProcessor {
    private static final String SEPARATOR = ",";

    CoachNamesValidation coachNamesValidation = new CoachNamesValidation();
    RestrictedMenuValidation restrictedMenuValidation = new RestrictedMenuValidation();

    public List<String> processCoachNames(String input) {
        coachNamesValidation.validate(input);
        return Arrays.asList(input.split(SEPARATOR));
    }

    public List<String> processRestrictedMenus(String input) {
        restrictedMenuValidation.validate(input);
        return Arrays.asList(input.split(SEPARATOR));
    }
}
