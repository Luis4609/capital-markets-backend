package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IuserControllerService;
import com.capitalmarkets.app.dto.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

 /*   @Autowired
    private IuserControllerService iuserControllerService;*/

    //Registrar nuevo usuario
        //1Comprobar que el usuario existe o no
      // 2Si no existe se guarda
    // si existe mandar mensaje a front

    @GetMapping("/register")
    @ResponseBody
    public String  registerUser(@RequestBody UserDTO userDTO){
        //comprobar si existe




            return  "";
    }



@GetMapping("/findUser")
    public void findUserByMail (@RequestParam(value = "mail") String mail){





}




}
