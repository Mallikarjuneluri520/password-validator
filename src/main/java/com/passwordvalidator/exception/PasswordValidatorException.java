package com.passwordvalidator.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class PasswordValidatorException extends Exception {

    private Object object;

    private String reason;



    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public PasswordValidatorException(Object object){
        this.object = object;

    }
}
