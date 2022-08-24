package com.capitalmarkets.app.data.providers;

import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
public class IUserProviderTestIntegration {
    @Autowired
    private IUserProvider iUserProvider;

    @Test
    public void getUserByDniTest() {
        UserDTO dto = iUserProvider.getUserByDni("69696969V");
        assertThat(dto).isNotNull();
        assertThat(dto.getDni()).isNotEmpty();
        assertThat(dto.getDni()).isEqualToIgnoringCase("69696969v");
        assertThat(dto.getDni()).isEqualTo("69696969V");
    }

    @Test
    public void getUserByMailTest() {
        UserDTO dto = iUserProvider.getUserByMail("celia@email.com");
        assertThat(dto).isNotNull();
        assertThat(dto.getMail()).isNotEmpty();
        assertThat(dto.getMail()).isEqualToIgnoringCase("CELIA@email.com");
        assertThat(dto.getMail()).isEqualTo("celia@email.com");

    }



    @Test
    public void userWithOutPassTest() {
        String mail = "celia@email.com";
        UserWithOutPassDTO userWithOutPassDTO = iUserProvider.userWithOutPass(mail);
        assertThat(userWithOutPassDTO).isNotNull();
        assertThat(userWithOutPassDTO.getDni()).isNotNull();
        assertThat(userWithOutPassDTO.getDni()).isNotEmpty();
        assertThat(userWithOutPassDTO.getName()).isNotEmpty();
        assertThat(userWithOutPassDTO.getName()).isNotNull();
        assertThat(userWithOutPassDTO.getSurname()).isNotEmpty();
        assertThat(userWithOutPassDTO.getSurname()).isNotNull();
        assertThat(userWithOutPassDTO.getMail()).isNotEmpty();
        assertThat(userWithOutPassDTO.getMail()).isNotNull();
        assertThat(userWithOutPassDTO.getMail()).isEqualToIgnoringCase("CELIA@email.com");
        assertThat(userWithOutPassDTO.getMail()).isEqualTo("celia@email.com");
    }

}
