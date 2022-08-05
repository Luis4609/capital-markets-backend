package com.capitalmarkets.app.data.providers;

import com.capitalmarkets.app.dto.data.UserDTO;

public interface IUserProvider {
    UserDTO getUserByDni(String dni);
    UserDTO getUserByMail(String mail);
}
