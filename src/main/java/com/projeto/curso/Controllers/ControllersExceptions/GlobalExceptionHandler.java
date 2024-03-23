package com.projeto.curso.Controllers.ControllersExceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.curso.Services.ServicesExceptions.getException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(getException.class)
    public ResponseEntity<StandardError> resouceNotFound(getException e, HttpServletRequest request) {
        String error = "Resouce not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError se = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(se);
    }
}
