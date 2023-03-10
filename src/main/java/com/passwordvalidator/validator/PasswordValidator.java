package com.passwordvalidator.validator;

import com.passwordvalidator.exception.PasswordValidatorException;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    Logger logger = LoggerFactory.getLogger(getClass());

    private static final String EMPTY_LOWER_CASE = "Password should not be empty or it should have at least one lower case letter. ";

    private static final String INVALID_LENGTH_UPPERCASE_DIGIT = "Password should contain at least one upper case letter or" +
            " password length should be at least 8 or password should have at least one digit.";

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
    public boolean isPasswordFormatValid(String password){

        if(StringUtils.isNotBlank(password) && password.matches("(.*[a-z].*)") && validateOtherScenarios(password)){
            logger.debug("validated password format");
            return true;
        }
        logger.error("invalid password format");
        throw new PasswordValidatorException(HttpStatus.BAD_REQUEST,EMPTY_LOWER_CASE);
    }

    private boolean validateOtherScenarios(String password) {

        if(password.matches("(.*[A-Z].*) ") || password.matches("(.*\\d.*)") || password.length()>7){
            return true;
        }
        logger.error("invalid password format excepting at least one upper case or length >7 or at least one digit");
        throw new PasswordValidatorException(HttpStatus.BAD_REQUEST,INVALID_LENGTH_UPPERCASE_DIGIT);
    }
}
