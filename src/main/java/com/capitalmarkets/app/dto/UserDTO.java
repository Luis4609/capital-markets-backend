package com.capitalmarkets.app.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    public String mail;
    public String name;
    public String password;

}
