package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.dto.core.LoginDTO;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
class IuserControllerServiceTestIntegration {
    @Autowired
    private IuserControllerService iuserControllerService;

    @Test
    void register() {
    }

    @Test
    void findByMailTest() {
        String mail="jesus@email.com";
        UserDTO result=iuserControllerService.findByMail(mail);
        UserDTO userDTOExpected=new UserDTO("Jesus","Casanova","69696969W","jesus@email.com","1234");
        assertThat(result).isNotNull();
        assertThat(result).toString();
        assertThat(result).isEqualTo(userDTOExpected);
        assertThat(result.getMail()).isEqualTo(userDTOExpected.getMail());
        assertThat(result.getSurname()).isEqualTo(userDTOExpected.getSurname());
        assertThat(result.getName()).isEqualTo(userDTOExpected.getName());
        assertThat(result.getDni()).isEqualTo(userDTOExpected.getDni());
        assertThat(result.getPassword()).isEqualTo(userDTOExpected.getPassword());

    }

    @Test
    void verifyPasswordTest() {
        LoginDTO loginDTO=new LoginDTO("jesus@email.com","1234");
        UserWithOutPassDTO userWithOutPassDTO= iuserControllerService.verifyPassword(loginDTO);
        UserWithOutPassDTO userExpected= new UserWithOutPassDTO("Jesus","Casanova","69696969W","jesus@email.com");
        assertThat(userWithOutPassDTO).isNotNull();

        assertThat(userWithOutPassDTO.getMail()).isEqualTo(userExpected.getMail());
        assertThat(userExpected.getMail()).isNotEmpty();

        assertThat(userExpected.getMail()).isNotNull();
        assertThat(userExpected.getMail()).toString();
        assertThat(userExpected.getName()).isNotNull();
        assertThat(userExpected.getName()).isNotEmpty();
        assertThat(userWithOutPassDTO.getName()).isEqualTo(userExpected.getName());
        assertThat(userWithOutPassDTO.getName()).isEqualTo(userExpected.getName());
        assertThat(userWithOutPassDTO.getMail()).isEqualTo(userExpected.getMail());
        assertThat(userWithOutPassDTO.getDni()).isEqualTo(userExpected.getDni());
        assertThat(userWithOutPassDTO.getSurname()).isEqualTo(userExpected.getSurname());

    }

    @Test
    void userWithOutPassByMailTest() {
        String mail = "jesus@email.com";
        UserWithOutPassDTO userWithOutPassDTO = iuserControllerService.userWithOutPassByMail(mail);
        UserWithOutPassDTO userWithOutPassDTO1 = new UserWithOutPassDTO("Jesus","Casanova","69696969W","jesus@email.com");
        assertThat(userWithOutPassDTO).isNotNull();
        assertThat(userWithOutPassDTO.getMail()).isNotEmpty();
        assertThat(userWithOutPassDTO.getMail()).asString();
        assertThat(userWithOutPassDTO.getMail()).toString();
        assertThat(userWithOutPassDTO.getMail()).endsWith("com");
        assertThat(userWithOutPassDTO.getMail()).containsPattern("@");
        assertThat(userWithOutPassDTO.getMail()).isEqualTo(userWithOutPassDTO1.getMail());
        assertThat(userWithOutPassDTO.getName()).isEqualTo(userWithOutPassDTO1.getName());
        assertThat(userWithOutPassDTO.getSurname()).isEqualTo(userWithOutPassDTO1.getSurname());
        assertThat(userWithOutPassDTO.getDni()).isEqualTo(userWithOutPassDTO1.getDni());
        assertThat(userWithOutPassDTO.getMail()).isEqualToIgnoringCase(userWithOutPassDTO1.getMail());

    }
}