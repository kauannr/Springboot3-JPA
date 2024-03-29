package com.projeto.curso.Controllers.ControllersExceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.curso.Services.ServicesExceptions.DatabaseException;
import com.projeto.curso.Services.ServicesExceptions.getException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(getException.class)
    public ResponseEntity<StandardError> resouceNotFound(getException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Resouce not found";

        StandardError se = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(se);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> integrityViolation(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Integrity violation";

        StandardError se = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(se);

    }
}
