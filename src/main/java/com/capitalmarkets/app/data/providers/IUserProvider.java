package com.capitalmarkets.app.data.providers;


import com.capitalmarkets.app.dto.UserDTO;

public interface IUserProvider {
    UserDTO getUserByName(String name);
    UserDTO getUserByMail(String mail);
    UserDTO getUserByPassword(String password);
}
