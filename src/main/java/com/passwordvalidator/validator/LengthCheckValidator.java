package com.passwordvalidator.validator;

import com.passwordvalidator.exception.PasswordValidatorException;
import org.springframework.stereotype.Component;

@Component
public class LengthCheckValidator implements IPasswordValidator{
    @Override
    public boolean validate(String password)  {
       return password.length()>7;


    }

    @Override
    public String getValidationMessage() {
        return "Length should be at least 8 characters";
    }

}
