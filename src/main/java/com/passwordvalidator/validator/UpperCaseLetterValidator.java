package com.passwordvalidator.validator;

import org.springframework.stereotype.Component;

@Component
public class UpperCaseLetterValidator implements IPasswordValidator{


        @Override
        public boolean validate(String password) {
                return password.matches("(.*[A-Z].*)");


        }

    @Override
    public String getValidationMessage() {
        return "Password should contain at least one upper case";
    }

}
