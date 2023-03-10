package com.passwordvalidator.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class PasswordValidatorException extends ResponseStatusException {
    public PasswordValidatorException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
