package com.ubervet.backend.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NO_CONTENT)
public class ListaVaziaException extends Throwable {

    public ListaVaziaException(String message) {
        super(message);
    }
}
