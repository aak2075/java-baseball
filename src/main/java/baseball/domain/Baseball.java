package baseball.domain;

public class Baseball {
    private static final int DIGIT_MIN = 1;
    private static final int DIGIT_MAX = 3;
    private final GameNumber answer;

    public Baseball(GameNumber answer) {
        this.answer = answer;
    }

    public int countBall(GameNumber input) {
        int count = 0;
        for (int digit = DIGIT_MIN; digit <= DIGIT_MAX; digit++) {
            if (answer.checkBall(input, digit)) {
                count = count + 1;
            }
        }
        return count;
    }

    public int countStrike(GameNumber input) {
        int count = 0;
        for (int digit = DIGIT_MIN; digit < DIGIT_MAX; digit++) {
            if (answer.checkStrike(input, digit)) {
                count = count + 1;
            }
        }
        return count;
    }

    public boolean isNothing(GameNumber input) {
        return countBall(input) + countStrike(input) == 0;
    }


}
