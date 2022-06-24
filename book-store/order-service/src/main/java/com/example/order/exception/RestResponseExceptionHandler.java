package com.example.order.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class RestResponseExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleNotFoundException(HttpServletResponse response, Exception ex) {
        log.error("Error exception while handling ", ex);
        return new ResponseEntity<>("Oop!!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
