package racingcar.view;

import racingcar.message.Message;
import racingcar.model.Car;
import racingcar.model.Game;

import java.util.List;

public class OutputView {

    static public void printResult(Game game) {
        for(Car car: game.getCars()) {
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
    
    static public void printWinnerNames(List<String> winnerNames) {
        System.out.print(Message.FINAL_WINNER);
        String result = String.join(", ", winnerNames);
        System.out.println(result);
    }

}
