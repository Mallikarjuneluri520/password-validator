package com.passwordvalidator.service;

import com.passwordvalidator.validator.PasswordValidator;
import org.springframework.stereotype.Service;


@Service
public class PasswordValidatorService {

    private PasswordValidator passwordValidator;

    public PasswordValidatorService(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }

    public void validatePasswordFormat(String password){
         passwordValidator.isPasswordFormatValid(password);
    }

}
