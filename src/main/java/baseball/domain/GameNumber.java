package baseball.domain;

import java.util.List;

public class GameNumber {
    private final List<Integer> number;

    public GameNumber(List<Integer> number) {
        this.number = number;
    }

    public boolean equals(GameNumber input, int digit) {
        return number.get(digit-1).equals(input.number.get(digit-1));
    }

    public boolean contains(GameNumber input, int digit) {
        return number.contains(input.number.get(digit-1));
    }

    public boolean containsOnly(GameNumber input, int digit) {
        if (equals(input, digit)) {
            return false;
        }
        return contains(input, digit);
    }
}
