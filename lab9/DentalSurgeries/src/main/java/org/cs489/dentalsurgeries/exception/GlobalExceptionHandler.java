package org.cs489.dentalsurgeries.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.cs489.dentalsurgeries.exception.user.DataNotFound;
import org.cs489.dentalsurgeries.exception.user.DuplicateDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFound.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(DataNotFound e, HttpServletRequest request) {
        ApiError apiError=new ApiError(
                e.getMessage(),
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.value(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleDuplicateDataException(DuplicateDataException e, HttpServletRequest request) {
        ApiError apiError=new ApiError(
                e.getMessage(),
                request.getRequestURI(),
                HttpStatus.CONTINUE.value(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }
}
