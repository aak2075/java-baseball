package baseball.exceptions;

public class NumberRangeException extends RuntimeException {
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 범위에 해당하지 않는 숫자 입력";

    public NumberRangeException() {
        super(NUMBER_RANGE_ERROR_MESSAGE);
    }
}
