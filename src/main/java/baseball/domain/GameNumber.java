package baseball.domain;

import java.util.List;

public class GameNumber {
    private final List<Integer> number;

    public GameNumber(List<Integer> number) {
        this.number = number;
    }

    public boolean checkStrike(GameNumber input, int digit) {
        return number.get(digit).equals(input.number.get(digit));
    }

    public boolean checkBall(GameNumber input, int digit) {
        if (checkStrike(input, digit)) {
            return false;
        }
        return number.contains(input.number.get(digit));
    }
}
