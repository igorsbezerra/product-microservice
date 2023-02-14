package dev.igor.products.config;


import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import dev.igor.products.http.response.Error;
import jakarta.persistence.NoResultException;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<Error> noResult(NoResultException e) {
        return ResponseEntity.badRequest().body(new Error("X_100", e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Error> invalidParameter(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.badRequest().body(new Error("X_200", "Invalid parameter"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> invalidRequest(MethodArgumentNotValidException e) {
        var message = e.getBindingResult().getFieldErrors().stream()
            .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
            .collect(Collectors.joining());
        return ResponseEntity.badRequest().body(new Error("X_400", message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> unexpectedError(Exception e) {
        return ResponseEntity.badRequest().body(new Error("X_500", e.getMessage()));
    }
}
