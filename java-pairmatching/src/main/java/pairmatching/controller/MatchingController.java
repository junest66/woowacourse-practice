package pairmatching.controller;

import java.util.List;
import java.util.Set;
import pairmatching.utils.InputProcessor;
import pairmatching.domain.EducationModule;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatcher;
import pairmatching.domain.PairingHistory;
import pairmatching.utils.CrewNamesLoader;
import pairmatching.validator.FunctionValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final InputProcessor inputProcessor = new InputProcessor();
    private final PairingHistory pairingHistory = new PairingHistory();
    private final PairMatcher pairMatcher = new PairMatcher(pairingHistory);

    private static final String FUNCTION_PAIR_MATCHING = "1";
    private static final String FUNCTION_PAIR_QUERY = "2";
    private static final String FUNCTION_PAIR_RESET = "3";
    private static final String FUNCTION_QUIT = "Q";

    public void run() {
        while (true) {
            String functionNumber = inputView.readFunction();
            outputView.printCourseInfo();
            try {
                FunctionValidator.validate(functionNumber);
                handleFunction(functionNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (FUNCTION_QUIT.equals(functionNumber)) {
                break;
            }
        }
    }

    private void handleFunction(String functionNumber) {
        if (FUNCTION_PAIR_MATCHING.equals(functionNumber)) {
            handlePairMatching();
        } else if (FUNCTION_PAIR_QUERY.equals(functionNumber)) {
            handlePairQuery();
        } else if (FUNCTION_PAIR_RESET.equals(functionNumber)) {
            handlePairReset();
        }
    }

    private void handlePairMatching() {
        String courseInfo = inputView.readCourseInfo();
        EducationModule educationModule = inputProcessor.processCourseInfo(courseInfo);
        List<String> names = CrewNamesLoader.loadCrewNamesFromFile(educationModule.getCourse());

        if (!pairingHistory.hasPairing(educationModule.getCourse(), educationModule.getLevel())) {
            List<Pair> pairs = pairMatcher.matchPairs(names, educationModule);
            outputView.showPairingResult(pairs);
        } else if ("네".equals(inputView.readReMatching())) {
            pairingHistory.clearPairs(educationModule.getCourse(), educationModule.getLevel());
            List<Pair> pairs = pairMatcher.matchPairs(names, educationModule);
            outputView.showPairingResult(pairs);
        }
    }

    private void handlePairQuery() {
        String courseInfo = inputView.readCourseInfo();
        EducationModule educationModule = inputProcessor.processCourseInfo(courseInfo);
        Set<Pair> pairs = pairingHistory.getPairs(educationModule.getCourse(), educationModule.getLevel());

        if (pairs.isEmpty()) {
            outputView.showNoPairingHistoryMessage();
        } else {
            outputView.showPairingInfo(pairs);
        }
    }

    private void handlePairReset() {
        pairingHistory.clearAllPairs();
        outputView.printResetMessage();
    }
}
