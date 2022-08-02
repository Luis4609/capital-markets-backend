package com.capitalmarkets.app.data.providers.Impl;

import com.capitalmarkets.app.data.daos.IUserDao;
import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.data.mappers.Imapper;
import com.capitalmarkets.app.data.providers.IUserProvider;
import com.capitalmarkets.app.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProviderImpl implements IUserProvider {
    private final IUserDao userDao;
    private final Imapper<UserModel, UserDTO> mapper;


    @Override
    public UserDTO getUserByDni(String dni) {
        return userDao.getByDni(dni)
                .map(mapper::mapToDto)
                .orElse(null);
    }

    @Override
    public UserDTO getUserByMail(String mail) {
        return userDao.getByMail(mail)
                .map(mapper::mapToDto)
                .orElse(null);
    }
}
