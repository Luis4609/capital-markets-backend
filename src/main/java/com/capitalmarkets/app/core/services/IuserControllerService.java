package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.dto.data.UserDTO;
import java.util.List;

public interface IuserControllerService {


    void register (UserDTO userDTO);

   // List<UserDTO> getAllUsers();
    List<UserDTO> getAllUsers();

    UserDTO findByMail(String mail);

}
