package baseball.exceptions;

public class NumberSizeException extends RuntimeException{
    private static final String NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 입력의 크기는 3 입니다.";

    public NumberSizeException() {
        super(NUMBER_SIZE_ERROR_MESSAGE);
    }
}
