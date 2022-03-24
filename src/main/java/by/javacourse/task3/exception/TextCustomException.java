package by.javacourse.task3.exception;

public class TextCustomException extends Exception {
    public TextCustomException() {
    }

    public TextCustomException(String message) {
        super(message);
    }

    public TextCustomException(String message, Exception e) {
        super(message, e);
    }

    public TextCustomException(Exception e) {
        super(e);
    }
}
