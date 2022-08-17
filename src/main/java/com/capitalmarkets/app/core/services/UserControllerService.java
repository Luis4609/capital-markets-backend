package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.data.providers.IUserProvider;
import com.capitalmarkets.app.dto.core.LoginDTO;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserControllerService implements IuserControllerService {
    private final IUserProvider iUserProvider;

    @Override
    public void register(UserDTO userDTO) {

        iUserProvider.createUser(userDTO);

    }

/*    @Override
    public List<UserDTO> getAllUsers() {
        return (List<UserDTO>) iUserProvider.getAllUsers();


    }*/

    @Override
    public UserDTO findByMail(String mail) {
        return iUserProvider.getUserByMail(mail);
    }

    @Override
    public UserWithOutPassDTO userWithOutPassByMail(String mail){

       return iUserProvider.userWithOutPass(mail);

    }
    @Override
    public UserWithOutPassDTO verifyPassword(LoginDTO loginDTO) {
        UserDTO user = findByMail(loginDTO.getMail());
        UserWithOutPassDTO userWithOutPass=iUserProvider.userWithOutPass(loginDTO.getMail());
        //desciFrar contraseña que viene del front (loginDTO)
        //descifrar contraseña qeu viene del back (quizas en el provider del data???)
        if (user.getMail()!=null) {
            if(user.getPassword().equals(loginDTO.getPassword())){

                return userWithOutPass;
            }else{
                return new UserWithOutPassDTO("contraseña incorrecta");
            }
        }

       return userWithOutPass;
    }


}
