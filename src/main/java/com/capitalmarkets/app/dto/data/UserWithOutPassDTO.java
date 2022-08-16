package com.capitalmarkets.app.dto.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserWithOutPassDTO extends ExceptionDTO{


        private String name;
        private String surname;
        private String dni;
        private String mail;


  public UserWithOutPassDTO(String exception){
            super(exception);
        }

}
