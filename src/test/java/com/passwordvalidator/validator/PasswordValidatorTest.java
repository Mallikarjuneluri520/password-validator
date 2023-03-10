package com.passwordvalidator.validator;

import com.passwordvalidator.exception.PasswordValidatorException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
 class PasswordValidatorTest {

    private static final String INVALID_LENGTH_UPPERCASE_DIGIT = "Password should contain at least one upper case letter or" +
            " password length should be at least 8 or password should have at least one digit.";

    private static final String EMPTY_LOWER_CASE = "Password should not be empty or it should have at least one lower case letter. ";


    @Autowired
    private PasswordValidator passwordValidator;

    @Test
     void isPasswordFormatValidTestWithInvalidFormat(){

       PasswordValidatorException passwordValidatorException = assertThrows(PasswordValidatorException.class, () -> passwordValidator.isPasswordFormatValid("TEST"), "invalid password format exception");

       assertTrue(passwordValidatorException.getReason().equals(EMPTY_LOWER_CASE));
    }

    @Test
     void isPasswordFormatValidTestWithValidFormat(){

        assertThat(passwordValidator.isPasswordFormatValid("TESt123")).isTrue();
    }

    @Test
     void isPasswordFormatValidTestWithNullPassword(){

        PasswordValidatorException passwordValidatorException = assertThrows(PasswordValidatorException.class, () -> passwordValidator.isPasswordFormatValid(null),"invalid password format exception");
        assertTrue(passwordValidatorException.getReason().equals(EMPTY_LOWER_CASE));
    }

    @Test
     void isPasswordFormatValidTestWithoutUPPERCASECharacterAndLengthLessThan8(){

        assertThat(passwordValidator.isPasswordFormatValid("test123")).isTrue();
    }

    @Test
     void isPasswordFormatValidTestWithUPPERCASECharacterAndWithoutDigitAndLengthLessThan8(){

        assertThat(passwordValidator.isPasswordFormatValid("Test")).isTrue();
    }

    @Test
     void isPasswordFormatValidTestWithoutUPPERCASECharacterAndWithoutDigitAndLengthGreaterThan8(){

        assertThat(passwordValidator.isPasswordFormatValid("testpassword")).isTrue();
    }

    @Test
     void isPasswordFormatValidTestWithUPPERCASECharacterAndWithDigitAndLengthGreaterThan8(){

        PasswordValidatorException passwordValidatorException = assertThrows(PasswordValidatorException.class, () -> passwordValidator.isPasswordFormatValid("TEST123PASSWORD"),"invalid password format exception");
        assertTrue(passwordValidatorException.getReason().equals(EMPTY_LOWER_CASE));
    }

    @Test
     void isPasswordFormatValidTestWithAllConditionsValid(){

        assertThat(passwordValidator.isPasswordFormatValid("Test123Pass")).isTrue();
    }

    @Test
    void isPasswordFormatValidTestWithLowerCasePassword(){

       PasswordValidatorException passwordValidatorException =  assertThrows(PasswordValidatorException.class, () -> passwordValidator.isPasswordFormatValid("test"),"invalid password format exception");

       assertTrue(passwordValidatorException.getReason().equals(INVALID_LENGTH_UPPERCASE_DIGIT));
    }


}
