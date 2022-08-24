package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.dto.core.LoginDTO;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
public class UserRestControllerTestIntegration {
    @Autowired
    private UserRestController userRestController;


    @Test
    public void registerUserTest() {
        UserDTO userDTO = new UserDTO("Celia", "Salamanca", "00004567C", "emailnuevo@email.com", "E1232");
        UserWithOutPassDTO userWithOutPassDTO = userRestController.registerUser(userDTO);
        assertThat(userWithOutPassDTO).isNotNull();
        assertThat(userWithOutPassDTO.getMail()).isEqualTo("emailnuevo@email.com");
        assertThat(userWithOutPassDTO.getName()).isEqualTo("Celia");
        assertThat(userWithOutPassDTO.getSurname()).isEqualTo("Salamanca");
        assertThat(userWithOutPassDTO.getDni()).isEqualTo("00004567C");

    }

    @Test
    public void loginTest() {
        LoginDTO loginDTO = new LoginDTO("celia@email.com", "1234");
        UserWithOutPassDTO userWithOutPassDTO = userRestController.login(loginDTO);
        assertThat(userWithOutPassDTO).isNotNull();
        assertThat(userWithOutPassDTO.getMail()).isNotEmpty();
        assertThat(userWithOutPassDTO.getMail()).isEqualToIgnoringCase("celia@email.com");
        assertThat(userWithOutPassDTO.getMail()).isEqualTo("celia@email.com");
        LoginDTO loginDTOFalse = new LoginDTO("false@email.com", "123");
        UserWithOutPassDTO userWOPassDTOFalse = userRestController.login(loginDTOFalse);
        assertThat(userWOPassDTOFalse).isNotNull();
        assertThat(userWOPassDTOFalse.getMail()).isNull();

    }


}
