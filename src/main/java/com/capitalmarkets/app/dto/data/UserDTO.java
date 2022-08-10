package com.capitalmarkets.app.dto.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO extends ExceptionDTO {


    private String name;
    private String surname;
    private String dni;
    private String mail;
    private String password;

    public UserDTO(String exception){
        super(exception);
    }

}
