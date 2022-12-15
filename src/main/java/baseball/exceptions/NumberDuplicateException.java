package baseball.exceptions;

public class NumberDuplicateException extends RuntimeException {
    private static final String NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 입력에 중복이 존재합니다.";

    public NumberDuplicateException() {
        throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR_MESSAGE);
    }
}
