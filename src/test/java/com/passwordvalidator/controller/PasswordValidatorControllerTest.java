package com.passwordvalidator.controller;

import com.passwordvalidator.model.SignUp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PasswordValidatorControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {

        SignUp signUp = new SignUp();
        signUp.setPassword("domainTest1");
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/validate",signUp,
                String.class)).contains("valid");
    }
}
