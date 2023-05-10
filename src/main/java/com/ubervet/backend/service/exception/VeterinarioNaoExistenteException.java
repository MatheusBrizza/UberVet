package com.ubervet.backend.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VeterinarioNaoExistenteException extends Throwable {

    public VeterinarioNaoExistenteException(String message) {
        super(message);
    }
}
