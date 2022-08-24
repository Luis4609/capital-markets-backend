package com.capitalmarkets.app.dto.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class LoginDTOTestIntegration {


    private LoginDTO loginDTO = new LoginDTO("celia@email.com", "1234A");

    @Test
    void mailTest() {

        assertThat(loginDTO.getMail()).asString();
        assertThat(loginDTO.getMail()).isNotEmpty();
        assertThat(loginDTO.getMail()).isNotNull();
        assertThat(loginDTO.getMail()).isEqualToIgnoringCase("CELIA@EMAIL.COM");
        assertThat(loginDTO.getMail()).isEqualTo("celia@email.com");
        assertThat(loginDTO.getMail()).toString();


    }

    @Test
    void PasswordTest() {

        assertThat(loginDTO.getPassword()).asString();
        assertThat(loginDTO.getPassword()).isNotEmpty();
        assertThat(loginDTO.getPassword()).isNotNull();
        assertThat(loginDTO.getPassword()).isEqualToIgnoringCase("1234a");
        assertThat(loginDTO.getPassword()).isEqualTo("1234A");
        assertThat(loginDTO.getPassword()).toString();


    }


}