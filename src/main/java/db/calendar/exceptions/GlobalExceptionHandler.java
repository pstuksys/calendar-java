package db.calendar.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import db.calendar.reusable.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, CustomEntityNotFoundException.class})
    public ResponseEntity<ApiResponse<String>> handleEntityNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<String>(ex.getMessage()));
    }


    @ExceptionHandler({IllegalArgumentException.class, CustomIllegalArgumentException.class})
    public ResponseEntity<ApiResponse<String>> handleIllegalArgumentException(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ApiResponse<String>(ex.getMessage()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse<String>> handleNullPointerException(NullPointerException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse<String>(ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse<String>(ex.getMessage()));
    }

    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity<ApiResponse<String>> handleNoSuchFieldException(NoSuchFieldException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse<String>(ex.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<String>> handleConstraintViolationException(ConstraintViolationException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse<String>(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse<String>(ex.getMessage()));
    }

}
