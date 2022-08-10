package com.capitalmarkets.app.data.providers;

import com.capitalmarkets.app.dto.data.UserDTO;

import java.util.Collection;

public interface IUserProvider {
    UserDTO getUserByDni(String dni);
    UserDTO getUserByMail(String mail);

    void createUser(UserDTO userDTO);


    Collection<UserDTO> getAllUsers();


}
