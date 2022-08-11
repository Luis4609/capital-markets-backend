package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.data.providers.IUserProvider;
import com.capitalmarkets.app.dto.core.LoginDTO;
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

    @Override
    public UserDTO verifyPassword(LoginDTO loginDTO) {

        UserDTO user=findByMail(loginDTO.getMail());


            //desciFrar contraseña que viene del front (loginDTO)

            //descifrar contraseña qeu viene del back (quizas en el provider del data???)


            //comparamos las contraseñas
            if(loginDTO.getPassword().equals(user.getPassword())){
                System.out.println("las contraseñas son iguales");
                return user;
            }



        return new UserDTO("No existe un usuario con ese mail o la contraseña no es valida");
    }


}
