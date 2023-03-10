package com.passwordvalidator.controller;

import com.passwordvalidator.model.SignUp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PasswordValidatorControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void validatePasswordOKResponseTest() {

        SignUp signUp = new SignUp();
        signUp.setPassword("domainTest1");
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("http://localhost:" + port + "/validate",signUp,
                String.class);

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void validatePasswordBadRequestResponseTest() {

        SignUp signUp = new SignUp();
        signUp.setPassword("TEST");
        ResponseEntity<String> responseEntity =this.restTemplate.postForEntity("http://localhost:" + port + "/validate",signUp,
                String.class);

        assertTrue(responseEntity.getStatusCode().is4xxClientError());
    }
}
