package com.capitalmarkets.app.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO extends ExceptionDTO{

    public String mail;
    public String name;
    public String dni;
    public String password;

    public UserDTO(String exception){
        super(exception);
    }

}
