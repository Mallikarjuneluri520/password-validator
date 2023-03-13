package com.passwordvalidator.validator;

import com.passwordvalidator.exception.PasswordValidatorException;
import org.springframework.stereotype.Component;

@Component
public class LowerCaseValidator implements IPasswordValidator{
    @Override
    public boolean validate(String password) {

            return password.matches("(.*[a-z].*)");
    }

    @Override
    public String getValidationMessage() {
        return "Password should contain at least one lower case letter";
    }
}
