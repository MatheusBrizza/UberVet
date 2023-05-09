package com.ubervet.UberVet.backend.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VeterinarioExistenteException extends ResponseStatusException {

    public VeterinarioExistenteException(HttpStatus status, String message) {
        super(status, message);
    }
}
