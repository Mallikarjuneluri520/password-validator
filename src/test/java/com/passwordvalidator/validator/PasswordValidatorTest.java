package com.passwordvalidator.validator;

import com.passwordvalidator.exception.PasswordValidatorException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class PasswordValidatorTest {

    @Autowired
    private PasswordValidator passwordValidator;

    @Test
    public void isPasswordFormatValidTestWithInvalidFormat(){

        assertThrows(PasswordValidatorException.class, () -> passwordValidator.isPasswordFormatValid("TEST"), "Password should not be empty or it should have at least one lower case letter.");
    }

    @Test
    public void isPasswordFormatValidTestWithValidFormat(){

        assertThat(passwordValidator.isPasswordFormatValid("TESt123")).isTrue();
    }

    @Test
    public void isPasswordFormatValidTestWithNullPassword(){

        assertThrows(PasswordValidatorException.class, () -> passwordValidator.isPasswordFormatValid(null),"Password should not be empty or it should have at least one lower case letter.");
    }

    @Test
    public void isPasswordFormatValidTestWithOutUPPERCASECharacterAndLengthLessThan8(){

        assertThat(passwordValidator.isPasswordFormatValid("test123")).isTrue();
    }


}
