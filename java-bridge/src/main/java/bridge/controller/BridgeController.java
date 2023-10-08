package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private OutputView outputView;
    private InputView inputView;
    private BridgeMaker bridgeMaker;
    private User user;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.user = new User();
        this.bridgeGame = new BridgeGame();
    }

    public void run() {
        outputView.printStart();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        user.setBridge(bridge);
        while (bridgeGame.getGameStatus() && bridgeGame.getCurrentUpMap().size() < bridge.size()) {
            String inputMoving = inputView.readMoving();
            boolean result = bridge.get(bridgeGame.getCurrentUpMap().size()).equals(inputMoving);
            if (result) {
                if (inputMoving.equals("U")) {
                    bridgeGame.addCurrentUpMap("O");
                    bridgeGame.addCurrentDownMap(" ");
                }
                if (inputMoving.equals("D")) {
                    bridgeGame.addCurrentDownMap("O");
                    bridgeGame.addCurrentUpMap(" ");
                }
                outputView.printMap(bridgeGame.getCurrentUpMap(), bridgeGame.getCurrentDownMap());
            }
            if (!result) {
                if (inputMoving.equals("U")) {
                    bridgeGame.addCurrentUpMap("X");
                    bridgeGame.addCurrentDownMap(" ");
                }
                if (inputMoving.equals("D")) {
                    bridgeGame.addCurrentDownMap("X");
                    bridgeGame.addCurrentUpMap(" ");
                }
                outputView.printMap(bridgeGame.getCurrentUpMap(), bridgeGame.getCurrentDownMap());
                String restartInput = inputView.readGameCommand();
                if (restartInput.equals("R")) {
                    bridgeGame.initCurrentMap();
                    user.setCurrentCount(user.getCurrentCount() + 1);
                }
                if (restartInput.equals("Q")) {
                    bridgeGame.retry();
                }
            }
        }
        outputView.printResult(user.getCurrentCount(), bridgeGame, getGameResult(bridgeGame));


    }

    public String getGameResult(BridgeGame bridgeGame) {
        if (bridgeGame.getCurrentUpMap().contains("X")) {
            return "실패";
        }
        if (bridgeGame.getCurrentDownMap().contains("X")) {
            return "실패";
        }
        return "성공";
    }

}
