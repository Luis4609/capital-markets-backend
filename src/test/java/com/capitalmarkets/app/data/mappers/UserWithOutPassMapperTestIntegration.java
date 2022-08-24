package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest()
public class UserWithOutPassMapperTestIntegration {
    @Autowired
    private UserWithOutPassMapper userWithOutPassMapper;


    @Test
    public void UserWOPassMapperToDTOTest() {
        UserModel userModel = new UserModel(0, "Celia", "Salamanca", "12345678B", "celia@email.com", "E1232");
        UserWithOutPassDTO userWithOutPassDTO = userWithOutPassMapper.mapToDto(userModel);
        assertThat(userWithOutPassDTO).isNotNull();
        assertThat(userWithOutPassDTO.getName()).isNotNull();
        assertThat(userWithOutPassDTO.getName()).isNotEmpty();
        assertThat(userWithOutPassDTO.getName()).isEqualToIgnoringCase("CELIA");
        assertThat(userWithOutPassDTO.getName()).isEqualTo("Celia");
        assertThat(userWithOutPassDTO.getSurname()).isNotNull();
        assertThat(userWithOutPassDTO.getSurname()).isNotEmpty();
        assertThat(userWithOutPassDTO.getSurname()).isEqualToIgnoringCase("SALAMANCA");
        assertThat(userWithOutPassDTO.getSurname()).isEqualTo("Salamanca");
        assertThat(userWithOutPassDTO.getMail()).isNotNull();
        assertThat(userWithOutPassDTO.getMail()).isNotEmpty();
        assertThat(userWithOutPassDTO.getMail()).asString();
        assertThat(userWithOutPassDTO.getMail()).isEqualToIgnoringCase("CELIA@email.com");
        assertThat(userWithOutPassDTO.getMail()).isEqualTo("celia@email.com");
        assertThat(userWithOutPassDTO.getMail()).toString();
        assertThat(userWithOutPassDTO.getMail()).containsPattern("^(.+)@(.+)$");
        assertThat(userWithOutPassDTO.getDni()).isNotNull();
        assertThat(userWithOutPassDTO.getDni()).isNotEmpty();
        assertThat(userWithOutPassDTO.getDni()).asString();
        assertThat(userWithOutPassDTO.getDni()).isEqualToIgnoringCase("12345678b");
        assertThat(userWithOutPassDTO.getDni()).isEqualTo("12345678B");
        assertThat(userWithOutPassDTO.getDni()).hasSize(9);
        assertThat(userWithOutPassDTO.getDni()).toString();
        assertThat(userWithOutPassDTO.getDni()).containsPattern("^[0-9]{8}[A-Z]{1}$");

    }

    @Test
    public void UserWOmapperToEntity() {
        UserWithOutPassDTO userWithOutPassDTO = new UserWithOutPassDTO("Celia", "Salamanca", "12345678B", "celia@email.com");
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> userWithOutPassMapper.mapToEntity(userWithOutPassDTO))
        ;

    }


}
