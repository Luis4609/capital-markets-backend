package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IuserControllerService;
import com.capitalmarkets.app.dto.core.LoginDTO;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IuserControllerService iuserControllerService;

    @PostMapping("/register")
    public UserWithOutPassDTO registerUser(@RequestBody UserDTO userDTO) {
     /*   if (iuserControllerService.findByMail(userDTO.getMail()) == null) {
            return new UserWithOutPassDTO("no existe ese email");
        }*/
        iuserControllerService.register(userDTO);
        return iuserControllerService.userWithOutPassByMail(userDTO.getMail());
    }

    //este método solo se utiliza para pruebas
/*
    @GetMapping("/findAll")
    public List<UserDTO> getAll() {
        return iuserControllerService.getAllUsers();

    }
*/

    @GetMapping("/login")
    public UserWithOutPassDTO login(@RequestBody LoginDTO loginDTO){

        return iuserControllerService.verifyPassword(loginDTO);
   }


}
