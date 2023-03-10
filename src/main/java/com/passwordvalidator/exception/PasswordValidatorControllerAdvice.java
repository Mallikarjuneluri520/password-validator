package com.passwordvalidator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PasswordValidatorControllerAdvice {

        @ExceptionHandler(PasswordValidatorException.class)
        public ResponseEntity<?> handlePasswordValidatorException(PasswordValidatorException passwordValidatorException){

            return ResponseEntity.status(passwordValidatorException.getStatusCode()).body(passwordValidatorException.getReason());

        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> handleOtherExceptions(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
}
