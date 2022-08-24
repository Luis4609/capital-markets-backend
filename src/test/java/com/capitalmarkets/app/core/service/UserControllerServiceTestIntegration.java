package com.capitalmarkets.app.core.service;


import com.capitalmarkets.app.core.services.UserControllerService;
import com.capitalmarkets.app.dto.core.LoginDTO;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class UserControllerServiceTestIntegration {

    @Autowired
    private UserControllerService userControllerService;


    @Test // OK
    public void findByMailTestOK() {
        String mail = "luis@email.com";
        UserDTO userDTO = new UserDTO("Luis", "Monzon", "69696969V", "luis@email.com", "1234");
        UserDTO userDTO1 = userControllerService.findByMail("luis@email.com");

        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getMail()).isNotNull();
        assertThat(userDTO.getMail()).isNotEmpty();
        assertThat(userDTO.getMail()).isEqualToIgnoringCase("LUIS@email.com");
        assertThat(userDTO.getMail()).isEqualToNormalizingPunctuationAndWhitespace("luis@email.com");
        assertThat(userDTO.getMail()).toString();
        assertThat(userDTO.getMail()).asString();
        assertThat(userDTO.getMail()).containsPattern("^(.+)@(.+)$");
        assertThat(userDTO.getMail()).isEqualTo(userDTO1.getMail());
        assertThat(userDTO.getPassword()).isEqualTo(userDTO1.getPassword());
        assertThat(userDTO.getName()).isEqualTo(userDTO1.getName());
        assertThat(userDTO.getSurname()).isEqualTo(userDTO1.getSurname());
        assertThat(userDTO.getDni()).isEqualTo(userDTO1.getDni());
        assertThat(userDTO.getMail()).isEqualToIgnoringCase(userDTO1.getMail());
    }

    @Test // ok
    public void verifyPasswordTestOK() {
        LoginDTO loginDTO = new LoginDTO("luis@email.com", "1234");
        UserWithOutPassDTO result = userControllerService.verifyPassword(loginDTO);
        UserDTO expected = new UserDTO("Luis", "Monzon", "69696969V", "luis@email.com", "1234");

        assertThat(result).isNotNull();
        assertThat(result.getMail()).isNotNull();
        assertThat(result.getMail()).isNotEmpty();
        assertThat(result.getMail()).isEqualToIgnoringCase("LUIS@email.com");
        assertThat(result.getMail()).isEqualToNormalizingPunctuationAndWhitespace("luis@email.com");
        assertThat(result.getMail()).toString();
        assertThat(result.getMail()).asString();
        assertThat(result.getMail()).containsPattern("^(.+)@(.+)$");
        assertThat(result.getMail()).isEqualTo(expected.getMail());
        assertThat(result.getName()).isEqualTo(expected.getName());
        assertThat(result.getSurname()).isEqualTo(expected.getSurname());
        assertThat(result.getDni()).isEqualTo(expected.getDni());
        assertThat(result.getMail()).isEqualToIgnoringCase(expected.getMail());
        assertThat(result.getMail()).isEqualToIgnoringCase(expected.getMail());
        assertThat(expected.getPassword()).isEqualTo(loginDTO.getPassword());

        //assertThat(userDTO.getPassword()).containsPattern();
    }
}
