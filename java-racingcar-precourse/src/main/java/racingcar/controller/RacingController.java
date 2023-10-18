package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.message.Message;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private Game game;

    public RacingController() {
        this.game = new Game();
    }

    public void run() {
        List<String> carNames = InputView.getCarNames();
        int gameCount = InputView.getGameCount();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        game.setCount(gameCount);
        game.setCars(cars);
        start(game);
    }

    public void start(Game game) {
        System.out.println(Message.RESULT_MESSAGE);

        for (int i = 0; i < game.getCount(); i++) {
            moveCar(game);
            OutputView.printResult(game);
        }
        int maxPosition = getMaxPosition(game);
        OutputView.printWinnerNames(getWinnerNames(game, maxPosition));
    }

    private static List<String> getWinnerNames(Game game, int maxPosition) {
        return game.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveCar(Game game) {
        for (Car car : game.getCars()) {
            car.movePosition();
        }
    }

    private static int getMaxPosition(Game game) {
        int maxPosition = game.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return maxPosition;
    }
}
