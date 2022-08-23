package com.capitalmarkets.app.dto.data;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.builder.ToStringExclude;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO extends ExceptionDTO {

    private String name;
    private String surname;
    private String dni;
    private String mail;
    //@Getter(AccessLevel.PRIVATE)
    private String password;

    public UserDTO(String exception){
        super(exception);
    }

}
