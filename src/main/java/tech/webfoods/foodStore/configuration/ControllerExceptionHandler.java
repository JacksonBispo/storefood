package tech.webfoods.foodStore.configuration;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.webfoods.foodStore.exceptions.AuthorizationException;
import tech.webfoods.foodStore.exceptions.StandardError;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFound404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity badRequest400(MethodArgumentNotValidException ex){

        var list = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(list.stream().map(ErrorValidationData::new).toList());
    }

    public record ErrorValidationData(String field, String message){

        public ErrorValidationData(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> authorization(ObjectNotFoundException e, HttpServletRequest req){
        StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(),e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
    }
}
