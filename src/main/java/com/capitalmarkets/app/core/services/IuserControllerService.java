package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.dto.core.LoginDTO;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;

import java.util.List;

public interface IuserControllerService {
    void register (UserDTO userDTO);

  /*  List<UserDTO> getAllUsers();*/
    UserDTO findByMail(String mail);
    UserWithOutPassDTO verifyPassword(LoginDTO loginDTO);

    UserWithOutPassDTO userWithOutPassByMail(String mail);

    void restartPassword();
}
