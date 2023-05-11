package com.ubervet.backend.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VeterinarioNaoExistenteException extends Throwable {

    public VeterinarioNaoExistenteException(String message) {
        super(message);
    }
}
