package baseball.domain;

import baseball.exceptions.NumberDuplicateException;
import baseball.exceptions.NumberRangeException;
import baseball.exceptions.NumberSizeException;

import java.util.List;
import java.util.stream.Collectors;

public class GameNumber {
    private final List<Integer> number;

    public GameNumber(List<Integer> number) {
        validate(number);
        this.number = number;
    }

    private void validate(List<Integer> number) {
        checkSize(number);
        checkRange(number);
        checkDuplicate(number);
    }

    private void checkSize(List<Integer> number) {
        if (number.size() != 3) {
            throw new NumberSizeException();
        }
    }

    private void checkRange(List<Integer> number) {
        long count = number.stream()
                .filter(each -> each >= 1 && each <= 9)
                .count();
        if (count != number.size()) {
            throw new NumberRangeException();
        }
    }

    private void checkDuplicate(List<Integer> number) {
        List<Integer> distinct = number.stream()
                .distinct()
                .collect(Collectors.toList());

        if (distinct.size() != number.size()) {
            throw new NumberDuplicateException();
        }
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
