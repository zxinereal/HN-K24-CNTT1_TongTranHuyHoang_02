package org.example.bookingservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MovieNotFoundException.class)
    public ProblemDetail handleMovieNotFound(MovieNotFoundException exception) {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
        detail.setTitle("Movie không tồn tại");
        return detail;
    }
    @ExceptionHandler(MovieServiceException.class)
    public ProblemDetail handleMovieService(MovieServiceException exception) {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_GATEWAY, exception.getMessage());
        detail.setTitle("Movie service không hoạt động");
        return detail;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new LinkedHashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> errors.putIfAbsent(error.getField(), error.getDefaultMessage()));

        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "không hoat động");
        detail.setTitle("Yêu cầu không hợp lệ");
        detail.setProperty("errors", errors);
        return detail;
    }
}
