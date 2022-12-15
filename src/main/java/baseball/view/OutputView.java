package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void start() {
       System.out.println(GAME_START_MESSAGE);
    }

    public static void inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void result(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball + BALL_MESSAGE + " ");
        }
        if (strike > 0) {
            sb.append(strike + STRIKE_MESSAGE + " ");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
    }

    public static void correct() {
        System.out.println(CORRECT_MESSAGE);
        System.out.println(INPUT_REPLAY_MESSAGE);
    }
}
