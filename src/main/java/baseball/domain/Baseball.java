package baseball.domain;

public class Baseball {
    private static final int DIGIT_MIN = 1;
    private static final int DIGIT_MAX = 3;
    private final int answer;

    public Baseball(int answer) {
        this.answer = answer;
    }

    public int countBall(int input) {
        String[] inputStr = Integer.toString(input).split("");
        int count = 0;
        for (int digit = DIGIT_MIN; digit <= DIGIT_MAX; digit++) {
            if (checkBall(inputStr[digit], digit)) {
                count = count + 1;
            }
        }
        return count;
    }

    public int countStrike(int input) {
        String[] inputStr = Integer.toString(input).split("");
        int count = 0;
        for (int digit = DIGIT_MIN; digit < DIGIT_MAX; digit++) {
            if (checkStrike(inputStr[digit], digit)) {
                count = count + 1;
            }
        }
        return count;
    }

    public boolean isNothing(int input) {
        return countBall(input) + countStrike(input) == 0;
    }

    private boolean checkStrike(String each, int digit) {
        String answerStr = Integer.toString(answer);
        return answerStr.substring(digit-1, digit).equals(each);
    }

    private boolean checkBall(String each, int digit) {
        if (checkStrike(each, digit)) {
            return false;
        }
        String answerStr = Integer.toString(answer);
        return answerStr.contains(each);
    }
}
