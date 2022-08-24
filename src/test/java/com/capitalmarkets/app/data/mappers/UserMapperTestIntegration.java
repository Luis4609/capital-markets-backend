package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.dto.data.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
public class UserMapperTestIntegration {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void mapperUserToDtoTest() {
        UserModel userModel = new UserModel(0, "Celia", "Salamanca", "12345678B", "celia@email.com", "E1232");
        UserDTO dto = userMapper.mapToDto(userModel);
        assertThat(dto).isNotNull();
        assertThat(dto.getName()).isNotNull();
        assertThat(dto.getName()).isNotEmpty();
        assertThat(dto.getName()).isEqualToIgnoringCase("CELIA");
        assertThat(dto.getName()).isEqualTo("Celia");
        assertThat(dto.getSurname()).isNotNull();
        assertThat(dto.getSurname()).isNotEmpty();
        assertThat(dto.getSurname()).isEqualToIgnoringCase("SALAMANCA");
        assertThat(dto.getSurname()).isEqualTo("Salamanca");
        assertThat(dto.getMail()).isNotNull();
        assertThat(dto.getMail()).isNotEmpty();
        assertThat(dto.getMail()).asString();
        assertThat(dto.getMail()).isEqualToIgnoringCase("CELIA@email.com");
        assertThat(dto.getMail()).isEqualTo("celia@email.com");
        assertThat(dto.getMail()).toString();
        assertThat(dto.getMail()).containsPattern("^(.+)@(.+)$");
        assertThat(dto.getDni()).isNotNull();
        assertThat(dto.getDni()).isNotEmpty();
        assertThat(dto.getDni()).asString();
        assertThat(dto.getDni()).isEqualToIgnoringCase("12345678b");
        assertThat(dto.getDni()).isEqualTo("12345678B");
        assertThat(dto.getDni()).hasSize(9);
        assertThat(dto.getDni()).toString();
        assertThat(dto.getDni()).containsPattern("^[0-9]{8}[A-Z]{1}$");
        assertThat(dto.getPassword()).isNotNull();
        assertThat(dto.getPassword()).isNotEmpty();
        assertThat(dto.getPassword()).asString();
        assertThat(dto.getPassword()).isEqualToIgnoringCase("e1232");
        assertThat(dto.getPassword()).isEqualTo("E1232");

    }

    @Test
    public void mapperUserToEntityTest() {
        UserDTO userDTO = new UserDTO("Celia", "Salamanca", "12345678B", "celia@email.com", "E1232");
        UserModel userModel = userMapper.mapToEntity(userDTO);
        assertThat(userModel).isNotNull();
        assertThat(userModel.getName()).isNotNull();
        assertThat(userModel.getName()).isNotEmpty();
        assertThat(userModel.getName()).isEqualToIgnoringCase("CELIA");
        assertThat(userModel.getName()).isEqualTo("Celia");
        assertThat(userModel.getSurname()).isNotNull();
        assertThat(userModel.getSurname()).isNotEmpty();
        assertThat(userModel.getSurname()).isEqualToIgnoringCase("SALAMANCA");
        assertThat(userModel.getSurname()).isEqualTo("Salamanca");
        assertThat(userModel.getMail()).isNotNull();
        assertThat(userModel.getMail()).isNotEmpty();
        assertThat(userDTO.getMail()).asString();
        assertThat(userModel.getMail()).isEqualToIgnoringCase("CELIA@email.com");
        assertThat(userModel.getMail()).isEqualTo("celia@email.com");
        assertThat(userDTO.getMail()).toString();
        assertThat(userDTO.getMail()).containsPattern("^(.+)@(.+)$");
        assertThat(userDTO.getDni()).isNotNull();
        assertThat(userDTO.getDni()).isNotEmpty();
        assertThat(userDTO.getDni()).asString();
        assertThat(userDTO.getDni()).isEqualToIgnoringCase("12345678b");
        assertThat(userDTO.getDni()).isEqualTo("12345678B");
        assertThat(userModel.getDni()).hasSize(9);
        assertThat(userDTO.getDni()).toString();
        assertThat(userDTO.getDni()).containsPattern("^[0-9]{8}[A-Z]{1}$");
        assertThat(userDTO.getPassword()).isNotNull();
        assertThat(userDTO.getPassword()).isNotEmpty();
        assertThat(userDTO.getPassword()).asString();
        assertThat(userDTO.getPassword()).isEqualToIgnoringCase("e1232");
        assertThat(userDTO.getPassword()).isEqualTo("E1232");

    }


}
