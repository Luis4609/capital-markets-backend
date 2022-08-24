package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IuserControllerService;
import com.capitalmarkets.app.dto.core.LoginDTO;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@RunWith(MockitoJUnitRunner.Silent.class)
@ExtendWith(MockitoExtension.class)
class UserRestControllerTest {
    @Mock
    private IuserControllerService iuserControllerService;
    @InjectMocks
    private UserRestController userRestController;
    @Mock
    private UserWithOutPassDTO userWithOutPassDTO;
    @Mock
    private UserDTO userDTO;
    @Mock
    private LoginDTO loginDTO;

    @Test
    void registerUser() {
        userDTO = new UserDTO("celia", "salamanca", "12345678B", "celia@email.com", "1234");
        userWithOutPassDTO = new UserWithOutPassDTO("celia", "salamanca", "12345678B", "celia@email.com");
        Mockito.when(iuserControllerService.userWithOutPassByMail(userDTO.getMail())).thenReturn(userWithOutPassDTO);
        UserWithOutPassDTO result = userRestController.registerUser(userDTO);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(userWithOutPassDTO, result);
    }

    @Test
    void login() {
        userWithOutPassDTO = new UserWithOutPassDTO("celia", "salamanca", "12345678B", "celia@email.com");
        loginDTO = new LoginDTO("celia@email.com", "1234");
        Mockito.when(iuserControllerService.verifyPassword(loginDTO)).thenReturn(userWithOutPassDTO);
        UserWithOutPassDTO result = userRestController.login(loginDTO);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(userWithOutPassDTO, result);
    }
}