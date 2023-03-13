package com.passwordvalidator.validator;


public interface IPasswordValidator {

    boolean validate(String password) ;

    String getValidationMessage();
}
