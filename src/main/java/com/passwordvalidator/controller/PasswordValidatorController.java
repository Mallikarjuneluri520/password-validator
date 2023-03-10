package com.passwordvalidator.controller;

import com.passwordvalidator.exception.PasswordValidatorException;
import com.passwordvalidator.model.SignUp;
import com.passwordvalidator.service.PasswordValidatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate")
public class PasswordValidatorController {

    private PasswordValidatorService passwordValidatorService;

    public PasswordValidatorController(PasswordValidatorService passwordValidatorService) {
        this.passwordValidatorService = passwordValidatorService;
    }

    @PostMapping
    public ResponseEntity<?> validatePassword(@RequestBody SignUp signUp) {

        try {
            passwordValidatorService.validatePasswordFormat(signUp.getPassword());
            return ResponseEntity.ok("valid");
        } catch (PasswordValidatorException pve) {
            return ResponseEntity.badRequest().body(pve.getReason());
        }
    }
}
