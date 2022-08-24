package com.capitalmarkets.app.dto.core;

import com.capitalmarkets.app.dto.data.ExceptionDTO;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.swing.*;

//@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDTO {


private String mail;

private String password;

    public LoginDTO(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
}
