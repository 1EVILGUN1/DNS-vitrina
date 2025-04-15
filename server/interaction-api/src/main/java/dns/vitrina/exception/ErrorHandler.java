package dns.vitrina.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotDateBaseUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotDateBaseUserException(NotDateBaseUserException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(AddedUserException.class)
    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    public ErrorResponse handleAddedUserException(AddedUserException e) {
        return new ErrorResponse(e.getMessage());
    }

    record ErrorResponse(String error) {
    }
}
