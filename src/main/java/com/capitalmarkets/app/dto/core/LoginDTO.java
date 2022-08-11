package com.capitalmarkets.app.dto.core;

import com.capitalmarkets.app.dto.data.ExceptionDTO;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class LoginDTO {

private String mail;
private String password;


}
