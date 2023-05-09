package com.ubervet.UberVet.backend.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ListaVaziaException extends ResponseStatusException {

    public ListaVaziaException(HttpStatus status, String message) {
        super(status, message);
    }
}
