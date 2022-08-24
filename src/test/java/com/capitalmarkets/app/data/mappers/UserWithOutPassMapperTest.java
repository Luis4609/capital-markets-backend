package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserWithOutPassMapperTest {
    @InjectMocks
    private UserWithOutPassMapper userWithOutPassMapper;
    @Mock
    private UserWithOutPassDTO userWithOutPassDTO;
    @Mock
    private UserModel userModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userWithOutPassDTO = new UserWithOutPassDTO("celia", "salamanca", "12345678B", "celia@hotmail.com");
        userModel = new UserModel(0, "celia", "salamanca", "12345678B", "celia@hotmail.com", "1234");
    }

    @Test
    void mapToDto() {
        UserWithOutPassDTO result = userWithOutPassMapper.mapToDto(userModel);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(userWithOutPassDTO, result);
        Assertions.assertEquals(userWithOutPassDTO.getMail(), result.getMail());
        Assertions.assertEquals(userWithOutPassDTO.getName(), result.getName());
        Assertions.assertEquals(userWithOutPassDTO.getDni(), result.getDni());
        Assertions.assertEquals(userWithOutPassDTO.getSurname(), result.getSurname());

    }


}