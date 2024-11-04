package com.example.urlshortener.app.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.urlshortener.app.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
@ControllerAdvice
public class ResourceExceptionHandler {
    /**
     * Handles ResourceNotFoundException and returns a ResponseEntity with StandardError.
     * 
     * @param e The ResourceNotFoundException that was thrown.
     * @param request The HttpServletRequest associated with the exception.
     * @return A ResponseEntity containing a StandardError object with details about the exception.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


}
