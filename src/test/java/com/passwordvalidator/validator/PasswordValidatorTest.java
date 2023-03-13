package com.passwordvalidator.validator;

import com.passwordvalidator.exception.PasswordValidatorException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
 class PasswordValidatorTest {
    
    @Autowired
    private PasswordValidator passwordValidator;

    @Test
     void isPasswordFormatValidTestWithInvalidFormat(){

      passwordValidator.isPasswordFormatValid("TEST");

       // assertTrue(passwordValidatorException.getReason().equals(EMPTY_LOWER_CASE));
    }

    @Test
     void isPasswordFormatValidTestWithValidFormat(){

        passwordValidator.isPasswordFormatValid("TESt123");
    }

    @Test
     void isPasswordFormatValidTestWithNullPassword(){

    passwordValidator.isPasswordFormatValid(null);
        // assertTrue(passwordValidatorException.getReason().equals(EMPTY_LOWER_CASE));
    }

    @Test
     void isPasswordFormatValidTestWithoutUPPERCASECharacterAndLengthLessThan8(){

        passwordValidator.isPasswordFormatValid("test123");
    }

    @Test
     void isPasswordFormatValidTestWithUPPERCASECharacterAndWithoutDigitAndLengthLessThan8(){

        passwordValidator.isPasswordFormatValid("Test");
    }

    @Test
     void isPasswordFormatValidTestWithoutUPPERCASECharacterAndWithoutDigitAndLengthGreaterThan8(){

        assertThat(passwordValidator.isPasswordFormatValid("testpassword"));
    }

    @Test
     void isPasswordFormatValidTestWithUPPERCASECharacterAndWithDigitAndLengthGreaterThan8(){

      passwordValidator.isPasswordFormatValid("TEST123PASSWORD");
    }

    @Test
     void isPasswordFormatValidTestWithAllConditionsValid(){

        passwordValidator.isPasswordFormatValid("Test123Pass");
    }

    @Test
    void isPasswordFormatValidTestWithLowerCasePassword(){

    passwordValidator.isPasswordFormatValid("test");

    }


}
