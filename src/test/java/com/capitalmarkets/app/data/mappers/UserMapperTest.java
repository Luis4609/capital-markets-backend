package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.dto.data.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {
    @InjectMocks
    private UserMapper userMapper;

    @Mock
    private UserDTO userDTO;
    @Mock
    private UserModel userModel;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        userDTO = new UserDTO("celia", "salamanca", "12345678B", "celia@hotmail.com", "1234");
        userModel = new UserModel(0, "celia", "salamanca", "12345678B", "celia@hotmail.com", "1234");
    }

    @Test
    void mapToDto() {
        UserDTO result = userMapper.mapToDto(userModel);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(userDTO, result);
        Assertions.assertEquals(userDTO.getMail(), result.getMail());
        Assertions.assertEquals(userDTO.getName(), result.getName());
        Assertions.assertEquals(userDTO.getPassword(), result.getPassword());
        Assertions.assertEquals(userDTO.getDni(), result.getDni());
        Assertions.assertEquals(userDTO.getSurname(), result.getSurname());


    }

    @Test
    void mapToEntity() {
        UserModel result = userMapper.mapToEntity(userDTO);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(userModel, result);
        Assertions.assertEquals(userModel.getMail(), result.getMail());
        Assertions.assertEquals(userModel.getName(), result.getName());
        Assertions.assertEquals(userModel.getPassword(), result.getPassword());
        Assertions.assertEquals(userModel.getDni(), result.getDni());
        Assertions.assertEquals(userModel.getSurname(), result.getSurname());


    }
}