package com.passwordvalidator.validator;

import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PasswordValidator {

    @Autowired
    private  List<IPasswordValidator> passwordValidatorList;

    Logger logger = LoggerFactory.getLogger(getClass());

    private static final String EMPTY_LOWER_CASE = "Password should not be empty or it should have at least one lower case letter. ";

    private static final String INVALID_LENGTH_UPPERCASE_DIGIT = "Password should contain at least one upper case letter or" +
            " should contain at least 8 characters or should have at least one digit.";

    /**
     * this method first check the mandatory conditions i.e., password is not null and
     *  password contains at least one lower case character and then verifies if any one
     * of the three conditions i.e.,password contains at least one upper case or
     * password contains at least one digit or password length should be at least 8.
     * if above-mentioned conditions meets then we consider that as a valid password.
     *
     * @param password
     * @return
     */
    public String isPasswordFormatValid(String password){


        if(StringUtils.isNotEmpty(password)) {
            for (IPasswordValidator passwordValidator : passwordValidatorList) {
                if (!passwordValidator.validate(password))

                    return passwordValidator.getValidationMessage();
            }
        }else{
            return "Password shouldn't be null";
        }

        return null;

    }

}
