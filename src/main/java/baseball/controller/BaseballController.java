package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.GameNumber;
import baseball.util.GameCommand;
import baseball.util.NumberGenerator;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private static final int NUMBER_SIZE = 3;

    private Baseball baseball;

    public void run() {
        init();
        play();
        replay();
    }

    private void init() {
        NumberGenerator generator = new RandomNumberGenerator();
        GameNumber answer = new GameNumber(generator.create(NUMBER_SIZE));
        baseball = new Baseball(answer);
    }

    private void play() {
        OutputView.inputNumber();
        GameNumber input = new GameNumber(InputView.readNumbers());
        int strike = baseball.countStrike(input);
        int ball = baseball.countBall(input);

        OutputView.result(ball, strike);
        if (strike != 3) {
            play();
        }
    }

    private void replay() {
        OutputView.correct();
        OutputView.inputReplay();
        GameCommand command = InputView.readReplay();
        if (command == GameCommand.REPLAY) {
            run();
        }
    }
}
