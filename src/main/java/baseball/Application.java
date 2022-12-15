package baseball;

import baseball.controller.BaseballController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.start();
        BaseballController controller = new BaseballController();
        controller.run();
    }
}
