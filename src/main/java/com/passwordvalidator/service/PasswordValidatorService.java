package com.passwordvalidator.service;

import com.passwordvalidator.validator.PasswordValidator;
import org.springframework.stereotype.Service;


@Service
public class PasswordValidatorService {

    private PasswordValidator passwordValidator;

    public PasswordValidatorService(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }

    public boolean validatePasswordFormat(String password){
        return passwordValidator.isPasswordFormatValid(password);
    }

}
