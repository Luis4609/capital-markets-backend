package com.capitalmarkets.app.data.providers.Impl;

import com.capitalmarkets.app.data.daos.IUserDao;
import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.data.mappers.Imapper;
import com.capitalmarkets.app.data.providers.IUserProvider;
import com.capitalmarkets.app.dto.data.UserDTO;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserProviderImpl implements IUserProvider {
    private final IUserDao userDao;
    private final Imapper<UserModel, UserDTO> mapper;

    private  final Imapper<UserModel, UserWithOutPassDTO> mapperWithOutPass;

    @Override
    public UserDTO getUserByDni(String dni) {
        return userDao.getByDni(dni)
                .map(mapper::mapToDto)
                .orElse(new UserDTO("No existe un usuario con ese dni"));
    }

    @Override
    public UserDTO getUserByMail(String mail) {
        return userDao.getByMail(mail)
                .map(mapper::mapToDto)
                .orElse(new UserDTO("No existe un usuario con ese mail"));
    }

    @Override
    public void createUser(UserDTO userDTO) {
        UserModel userModel= UserModel.builder()
                .dni(userDTO.getDni())
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .mail(userDTO.getMail())
                .password(userDTO.getPassword())
                .build();

        userDao.save(userModel);
    }

/*    @Override
    public Collection<UserDTO> getAllUsers() {

        return userDao.findAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }*/

    @Override
    public UserWithOutPassDTO userWithOutPass(String mail) {
        return userDao.getByMail(mail)
            .map(mapperWithOutPass::mapToDto)
                .orElse(new UserWithOutPassDTO("no existe ese usuario"))
                ;

    }


}
