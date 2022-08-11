package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IuserControllerService;
import com.capitalmarkets.app.dto.core.LoginDTO;
import com.capitalmarkets.app.dto.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IuserControllerService iuserControllerService;


    //hacer los cambios necesarios para que no devuelva la contraseña , dto nuevo, recorrido de vuelta a bbdd??
    //anotación que "elimina" un atributo de la clase ??
    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO) {

        if (iuserControllerService.findByMail(userDTO.getMail()) == null) {
            return null;
        }
        iuserControllerService.register(userDTO);
        return iuserControllerService.findByMail(userDTO.getMail());
    }

    //solo querremos el servicio pero el controller no vamos a utilizarlo, mas adelante lo eliminaremos
    // y solo implementamos la funcionalidad donde corresponda
    @GetMapping("/findUser")
    public UserDTO findUserByMail(@RequestParam String mail) {

        if (iuserControllerService.findByMail(mail) == null) {
            return null;

        }

        return iuserControllerService.findByMail(mail);
    }

    //este método solo se utiliza para pruebas
    @GetMapping("/findAll")
    public List<UserDTO> getAll() {

        return iuserControllerService.getAllUsers();


    }


    @GetMapping("/login")
    public UserDTO login(@RequestBody LoginDTO loginDTO){

        return iuserControllerService.verifyPassword(loginDTO);
   }


}
