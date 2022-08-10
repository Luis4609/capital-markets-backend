package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.data.providers.IUserProvider;
import com.capitalmarkets.app.dto.data.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@AllArgsConstructor
@Component
public class UserControllerService implements IuserControllerService{



    private final IUserProvider iUserProvider;




    @Override
    public void register(UserDTO userDTO) {

          iUserProvider.createUser(userDTO);

    }

    @Override
    public List<UserDTO> getAllUsers() {


        return (List<UserDTO>) iUserProvider.getAllUsers();


    }

    @Override
    public UserDTO findByMail(String mail) {
        return iUserProvider.getUserByMail(mail);
    }


    //crear/añadir (registro usuario) guardar



    //consultar por email

    //eliminar


    //modificar
}
