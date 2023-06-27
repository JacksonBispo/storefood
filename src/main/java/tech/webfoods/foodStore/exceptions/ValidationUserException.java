package tech.webfoods.foodStore.exceptions;

public class ValidationUserException    extends RuntimeException {

    public ValidationUserException(String message) {
        super(message);
    }

    public ValidationUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
