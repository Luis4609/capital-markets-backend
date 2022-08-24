package com.capitalmarkets.app.core.service;


import com.capitalmarkets.app.core.services.UserControllerService;
import com.capitalmarkets.app.dto.data.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class UserControllerServiceTestIntegration {

    @Autowired
    private UserControllerService userControllerService;


    @Test
    public void registerTestOK() {
        UserDTO userdto = new UserDTO("Luis", "Monzón", "50540431Y", "luis@gmail.com", "1234");

        assertThat(userdto).isNotNull();
        assertThat(userdto.getName()).isNotEmpty();
        assertThat(userdto.getSurname()).isNotEmpty();
        assertThat(userdto.getDni()).isNotEmpty();
        assertThat(userdto.getMail()).isNotEmpty();
        assertThat(userdto.getPassword()).isNotEmpty();
        assertThat(userdto.getName()).isNotNull();
        assertThat(userdto.getSurname()).isNotNull();
        assertThat(userdto.getDni()).isNotNull();
        assertThat(userdto.getMail()).isNotNull();
        assertThat(userdto.getPassword()).isNotNull();
        assertThat(userdto.getDni()).hasSize(9);
        assertThat(userdto.getName()).isEqualToNormalizingPunctuationAndWhitespace("Luis");
        assertThat(userdto.getSurname()).isEqualToNormalizingPunctuationAndWhitespace("Monzón");
        assertThat(userdto.getDni()).endsWith("Y");
        assertThat(userdto.getDni()).containsPattern("^[0-9]{8}[A-Z]{1}$");
        assertThat(userdto.getMail()).containsPattern("^(.+)@(.+)$");
        assertThat(userdto.getDni()).toString();
        assertThat(userdto.getDni()).asString();
        assertThat(userdto.getMail()).toString();
        assertThat(userdto.getMail()).asString();
        assertThat(userdto.getMail()).isEqualToIgnoringCase("LUIS@gmail.com");
        //assertThat(userdto.getMail()).hasSizeBetween(4, 8);

    }

    @Test
    public void findByMailTestOK() {
        UserDTO userDTO = new UserDTO("Luis", "Monzón", "50540431Y", "luis@gmail.com", "1234");

        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getMail()).isNotNull();
        assertThat(userDTO.getMail()).isNotEmpty();
        assertThat(userDTO.getMail()).isEqualToIgnoringCase("LUIS@gmail.com");
        assertThat(userDTO.getMail()).isEqualToNormalizingPunctuationAndWhitespace("luis@gmail.com");
        assertThat(userDTO.getMail()).toString();
        assertThat(userDTO.getMail()).asString();
        assertThat(userDTO.getMail()).containsPattern("^(.+)@(.+)$");
    }

    @Test
    public void verifyPasswordTestOK() {
        UserDTO userDTO = new UserDTO("Luis", "Monzón", "50540431Y", "luis@gmail.com", "1234");

        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getPassword()).isNotEmpty();
        assertThat(userDTO.getPassword()).isNotNull();
        assertThat(userDTO.getPassword()).isEqualToNormalizingPunctuationAndWhitespace("1234");
        assertThat(userDTO.getPassword()).hasSizeBetween(4, 8);
        assertThat(userDTO.getPassword()).toString();
        assertThat(userDTO.getPassword()).asString();
        //assertThat(userDTO.getPassword()).containsPattern();
    }
}
