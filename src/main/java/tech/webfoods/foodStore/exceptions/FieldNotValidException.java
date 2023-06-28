package tech.webfoods.foodStore.exceptions;

public class FieldNotValidException extends RuntimeException{

    public FieldNotValidException(String message) {
        super(message);
    }

    public FieldNotValidException(String message, Exception ex) {
        super(message, ex);
    }
}
