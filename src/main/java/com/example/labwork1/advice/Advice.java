package com.example.labwork1.advice;


import com.example.labwork1.exception.CustomException;
import com.example.labwork1.response.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class Advice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Response> handleException(@NotNull CustomException e) {
        logger.error("ERROR CODE 400", e);
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(@NotNull Exception e) {
        logger.error("ERROR CODE 500", e);
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}