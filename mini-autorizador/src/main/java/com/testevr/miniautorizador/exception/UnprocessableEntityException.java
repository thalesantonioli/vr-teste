package com.testevr.miniautorizador.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class UnprocessableEntityException extends ResponseStatusException {
    private Object body;
    public UnprocessableEntityException(Object body) {
        super(HttpStatus.UNPROCESSABLE_ENTITY);
        this.body = body;
    }
}
