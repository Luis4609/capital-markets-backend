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

    private String mail;
    private String name;
    private String dni;
    private String password;

    public UserDTO(String exception){
        super(exception);
    }

}
