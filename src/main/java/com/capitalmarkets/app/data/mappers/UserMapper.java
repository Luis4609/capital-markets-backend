package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.dto.data.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Imapper<UserModel, UserDTO> {


    @Override
    public UserDTO mapToDto(UserModel userModel) {
        UserDTO dto = new UserDTO(userModel.getName(), userModel.getMail(), userModel.getPassword(), userModel.getDni());
        return dto;
    }

    @Override
    public UserModel mapToEntity(UserDTO userDTO) {
        UserModel um = new UserModel(0, userDTO.name, userDTO.mail, userDTO.password, userDTO.dni);
        return null;
    }
}
