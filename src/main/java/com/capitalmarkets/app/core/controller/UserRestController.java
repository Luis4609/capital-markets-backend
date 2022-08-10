package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IuserControllerService;
import com.capitalmarkets.app.dto.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IuserControllerService iuserControllerService;

    @PostMapping("/register")

    public String registerUser(@RequestBody UserDTO userDTO) {
        iuserControllerService.register(userDTO);


        return "creado";
    }


    @GetMapping("/findUser")
    public boolean findUserByMail(@RequestBody String mail) {

        if (iuserControllerService.findByMail(mail) != null) {
            System.out.println(iuserControllerService.findByMail(mail));
            return true;
        }

        return false;

    }


    @GetMapping("/findAll")
    public List<UserDTO> getAll() {

        return iuserControllerService.getAllUsers();


    }


}
