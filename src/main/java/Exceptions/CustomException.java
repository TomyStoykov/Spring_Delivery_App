package Exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {
    public CustomException(String message, HttpStatus internalServerError) {
        super(message);
    }
}
