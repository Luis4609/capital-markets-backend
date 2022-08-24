package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.data.providers.IUserProvider;
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
class UserControllerServiceTest {

    @Mock
    private IUserProvider iUserProvider;

    @InjectMocks
    private UserControllerService userControllerService;

    @Mock
    private UserDTO userDTO;
    @Mock
    private UserWithOutPassDTO userWithOutPassDTO;

    @Mock
    private LoginDTO loginDTO;


    @Test
    void findByMail() {
        userDTO = new UserDTO("celia", "salamanca", "12345678B", "celia@email.com", "1234");
        Mockito.when(iUserProvider.getUserByMail("celia@email.com")).thenReturn(userDTO);
        UserDTO result = userControllerService.findByMail("celia@email.com");

        Assertions.assertNotNull(result);
        Assertions.assertInstanceOf(UserDTO.class, result);
        Assertions.assertEquals(userDTO, result);
        Assertions.assertSame(userDTO, result);

    }

    @Test
    void userWithOutPassByMail() {
        userWithOutPassDTO = new UserWithOutPassDTO("celia", "salamanca", "12345678B", "celia@email.com");
        Mockito.when(iUserProvider.userWithOutPass("celia@email.com")).thenReturn(userWithOutPassDTO);
        UserWithOutPassDTO result = userControllerService.userWithOutPassByMail("celia@email.com");

        Assertions.assertNotNull(result);
        Assertions.assertInstanceOf(UserWithOutPassDTO.class, result);
        Assertions.assertEquals(userWithOutPassDTO, result);
        Assertions.assertSame(userWithOutPassDTO, result);


    }

    @Test
    void verifyPassword() {
        userWithOutPassDTO = new UserWithOutPassDTO("celia", "salamanca", "12345678B", "celia@email.com");
        userDTO = new UserDTO("celia", "salamanca", "12345678B", "celia@email.com", "1234");
        loginDTO = new LoginDTO("celia@email.com", "1234");
        Mockito.when(iUserProvider.getUserByMail(loginDTO.getMail())).thenReturn(userDTO);
        if (userDTO.getMail() != null) {
            Mockito.when(iUserProvider.userWithOutPass(loginDTO.getMail())).thenReturn(userWithOutPassDTO);
            UserWithOutPassDTO result = userControllerService.verifyPassword(loginDTO);
            Assertions.assertNotNull(result);
            Assertions.assertInstanceOf(UserWithOutPassDTO.class, result);
            Assertions.assertEquals(userWithOutPassDTO, result);
        } else {
            LoginDTO loginWrong = new LoginDTO("celia@email.com", "00");
            UserWithOutPassDTO userException = new UserWithOutPassDTO("contraseña incorrecta");
            Mockito.when(iUserProvider.userWithOutPass(loginWrong.getMail())).thenReturn(userException);
            UserWithOutPassDTO result = userControllerService.verifyPassword(loginWrong);
            Assertions.assertNotNull(result);
            Assertions.assertInstanceOf(UserWithOutPassDTO.class, result);
            Assertions.assertEquals(userException, result);
        }
    }

}