package com.passwordvalidator.validator;

import com.passwordvalidator.exception.PasswordValidatorException;
import io.micrometer.common.util.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class NotNullValidator implements  IPasswordValidator{
    @Override
    public boolean validate(String password) {

             return StringUtils.isNotEmpty(password);

    }

    @Override
    public String getValidationMessage() {
        return "Password should not be empty or null";
    }
}
