package com.ubervet.UberVet.backend.utils;


import com.ubervet.UberVet.backend.model.Veterinario;
import org.apache.commons.validator.routines.EmailValidator;

public class EmailValidation {
    public static boolean isValidoEmail(Veterinario email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(Veterinario.builder().build().getEmail());
    }
}
