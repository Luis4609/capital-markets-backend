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
    private final IEmailService emailService;

    @Override
    public void register(UserDTO userDTO) {

        iUserProvider.createUser(userDTO);
    }

    @Override
    public UserDTO findByMail(String mail) {
        return iUserProvider.getUserByMail(mail);
    }

    @Override
    public UserWithOutPassDTO verifyPassword(LoginDTO loginDTO) {

        UserDTO user = iUserProvider.getUserByMail(loginDTO.getMail());

        if (user.getMail() != null) {
            if (user.getPassword().equals(loginDTO.getPassword())) {

                return iUserProvider.userWithOutPass(user.getMail());
            } else {
                return new UserWithOutPassDTO("contraseña incorrecta");
            }
        }

        return iUserProvider.userWithOutPass(user.getMail());
    }


    @Override
    public UserWithOutPassDTO userWithOutPassByMail(String mail) {
        return iUserProvider.userWithOutPass(mail);
    }

    @Override
    public void restartPassword() {
        String mail = "andres.ramos@optimissa.com";
        UserDTO userDTO = iUserProvider.getUserByMail(mail);
        String asunto = "Restablece tu contraseña de Capital Markets";

        emailService.send(mail, asunto, buildBody());

    }

    private String buildBody() {
        return  "<h2>Hola [userName],</h2>" +
                "<p>Has recibido este e-mail porque has solicitado recuperar tu contraseña. Si no has sido quien ha realizado esta solicitud, ignora este mensaje.</p>"+
                "<p>Para restablecer tu contraseña, haz click en esta URL o cópiala en tu navegador:</p>"+
                "<a href=https://capitalmarkets.andres.top/reset_password>https://capitalmarkets.andres.top/reset_password</a><br><br>"+
                "<p>Gracias por tu confianza,</p></br><em>Capital Markets</em><br>"+
                "<img src=https://capitalmarkets.andres.top/CM.png  width=\"400\" height=\"330\" />";
    }

}
