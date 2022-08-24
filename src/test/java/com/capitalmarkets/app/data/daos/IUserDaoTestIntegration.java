package com.capitalmarkets.app.data.daos;

import com.capitalmarkets.app.data.entities.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
public class IUserDaoTestIntegration {

    @Autowired
    private IUserDao iUserDao;

    @Test
    void userGetByDni() {
        UserModel userModel = new UserModel(0, "Celia", "Salamanca", "12345678B", "celia@email.com", "1232");
        String dni = "12345678B";

        assertThat(userModel.getDni()).isNotNull();
        assertThat(userModel.getDni()).isNotEmpty();
        assertThat(dni).hasSize(9);
        assertThat(userModel.getDni()).hasSize(9);
        assertThat(dni).containsPattern("^[0-9]{8}[A-Z]{1}$");
        assertThat(userModel.getDni()).containsPattern("^[0-9]{8}[A-Z]{1}$");
        assertThat(userModel.getDni()).isEqualTo(dni);
        assertThat(userModel.getDni()).isEqualToIgnoringCase(dni);
    }


    @Test
    void userGetByMail() {
        UserModel userModel = new UserModel(0, "Celia", "Salamanca", "12345678B", "celia@email.com", "1232");
        String mail = "celia@email.com";

        assertThat(mail).isNotNull();
        assertThat(mail).isNotEmpty();
        assertThat(userModel.getMail()).isNotNull();
        assertThat(userModel.getMail()).isNotEmpty();
        assertThat(userModel.getMail()).isEqualToIgnoringCase(mail);
        assertThat(userModel.getMail()).isEqualTo(mail);
        assertThat(mail).containsPattern("^(.+)@(.+)$");
        assertThat(userModel.getMail()).containsPattern("^(.+)@(.+)$");

    }
}
