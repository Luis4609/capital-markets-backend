package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IuserControllerService;
import com.capitalmarkets.app.dto.core.LoginDTO;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IuserControllerService iuserControllerService;

    @PostMapping("/login")
    public UserWithOutPassDTO login(@RequestBody LoginDTO loginDTO) {

        return iuserControllerService.verifyPassword(loginDTO);
    }

    @PostMapping("/register")
    public UserWithOutPassDTO registerUser(@RequestBody UserDTO userDTO) {

        iuserControllerService.register(userDTO);
        return iuserControllerService.userWithOutPassByMail(userDTO.getMail());
    }

    /*
    @GetMapping("/resetPassword")
    public void restartPassword() {
        iuserControllerService.restartPassword();
    }*/

//    @GetMapping("/findAll")
//    public List<UserDTO> getAll() {
//        return iuserControllerService.getAllUsers();
//
//    }

}
