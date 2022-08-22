package com.capitalmarkets.app.core.service;


import com.capitalmarkets.app.core.controller.UserRestController;
import static org.assertj.core.api.Assertions.assertThat;
import com.capitalmarkets.app.dto.data.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerServiceTestIntegration {

    @Autowired
    private UserRestController userRestController;


    @Test
    public void registerTestOK(){
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
            //assertThat(userdto.getMail()).hasSizeBetween(4, 8);

    }

    @Test
    public void findByMailTestOK(){
        UserDTO userDTO = new UserDTO("Luis", "Monzón", "50540431Y", "luis@gmail.com", "1234");

            assertThat(userDTO).isNotNull();
            assertThat(userDTO.getMail()).isNotNull();
            assertThat(userDTO.getMail()).isNotEmpty();
            assertThat(userDTO.getMail()).isEqualToIgnoringCase("luis@gmail.com");
            assertThat(userDTO.getMail()).isEqualToNormalizingPunctuationAndWhitespace("luis@gmail.com");
    }

    @Test
    public void verifyPasswordTest(){
        UserDTO userDTO = new UserDTO("Luis", "Monzón", "50540431Y", "luis@gmail.com", "1234");

            assertThat(userDTO).isNotNull();
            assertThat(userDTO.getPassword()).isNotEmpty();
            assertThat(userDTO.getPassword()).isNotNull();
            assertThat(userDTO.getPassword()).isEqualToNormalizingPunctuationAndWhitespace("1234");
            assertThat(userDTO.getPassword()).hasSizeBetween(4, 8);
    }
}
