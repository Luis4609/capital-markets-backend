package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Imapper<UserModel, UserDTO>  {


    @Override
    public UserDTO mapToDto(UserModel userModel) {
        UserDTO dto = new UserDTO(userModel.getName(), userModel.getSurname(),  userModel.getDni(), userModel.getMail(),userModel.getPassword());
        return dto;
    }



    @Override
    public UserModel mapToEntity(UserDTO userDTO) {
        UserModel um = new UserModel(0, userDTO.getName(), userDTO.getSurname() , userDTO.getDni(), userDTO.getMail(),userDTO.getPassword());
        return um;
    }




}
