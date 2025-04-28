package com.zerobase.weather.config;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Hidden
@RestControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> handleAllException(HttpServletRequest request, Exception e) {
        String uri = request.getRequestURI();

        System.out.println("error from GlobalExceptionHandler");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Exception());
    }

}
