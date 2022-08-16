package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class UserWithOutPassMapper implements Imapper<UserModel, UserWithOutPassDTO>{

    @Override
    public UserWithOutPassDTO mapToDto(UserModel userModel) {
        UserWithOutPassDTO dto = new UserWithOutPassDTO(userModel.getName(), userModel.getSurname(),  userModel.getDni(), userModel.getMail());
        return dto;
    }

    @Override
    public UserModel mapToEntity(UserWithOutPassDTO userWithOutPassDTO) {

        throw new UnsupportedOperationException();
    }
}
