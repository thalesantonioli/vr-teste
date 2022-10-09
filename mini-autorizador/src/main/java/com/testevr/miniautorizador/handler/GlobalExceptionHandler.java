package com.testevr.miniautorizador.handler;

import com.testevr.miniautorizador.exception.NotFoundException;
import com.testevr.miniautorizador.exception.UnprocessableEntityException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity handleUnprocessableEntityException(UnprocessableEntityException exception){
        return ResponseEntity.status(exception.getStatus()).body(exception.getBody());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(exception.getStatus()).build();
    }

}
