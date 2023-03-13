package com.passwordvalidator.validator;

import com.passwordvalidator.exception.PasswordValidatorException;
import org.springframework.stereotype.Component;

@Component
public class NumberValidator implements IPasswordValidator{
    @Override
    public boolean validate(String password)  {

            return password.matches("(.*\\d.*)");

    }

    @Override
    public String getValidationMessage() {
        return "Password should contain at least one number";
    }
}
