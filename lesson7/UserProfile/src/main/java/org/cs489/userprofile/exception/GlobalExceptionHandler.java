package org.cs489.userprofile.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.cs489.userprofile.exception.user.DuplicateUserException;
import org.cs489.userprofile.exception.user.UserNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<ApiError> handleDuplicateUserException(DuplicateUserException e, HttpServletRequest request) {
        ApiError apiError=new ApiError(
                e.getMessage(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                Instant.now()
                );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException e,
                                                                   HttpServletRequest request) {

        ApiError apiError=new ApiError(
                e.getMessage(),
                request.getRequestURI(),
                HttpStatus.CONTINUE.value(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException e, HttpServletRequest request) {
        ApiError apiError=new ApiError(
                e.getMessage(),
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.value(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
