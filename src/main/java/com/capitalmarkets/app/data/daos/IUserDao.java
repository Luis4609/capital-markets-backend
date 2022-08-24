package com.capitalmarkets.app.data.daos;

import com.capitalmarkets.app.data.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserDao extends JpaRepository<UserModel, String> {

    //Este método no se usa en ningún sitio
    Optional<UserModel[]> getByName(String name);

    Optional<UserModel> getByDni(String dni);

     Optional<UserModel> getByMail(String mail);

    void deleteByMail(String mail);


}
