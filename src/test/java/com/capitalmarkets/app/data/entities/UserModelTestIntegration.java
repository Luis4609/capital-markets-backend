package com.capitalmarkets.app.data.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
public class UserModelTestIntegration {

    private UserModel userModel;

    @Test
    void idAutoIncrementTest() {
        userModel = new UserModel(1, "Celia", "Salamanca", "12345678S", "celia@gmail.com", "1233");
        assertThat(userModel.getId()).isNotZero();
        assertThat(userModel.getId()).isNotNull();
        assertThat(userModel.getId()).isPositive();
        assertThat(userModel.getId()).isEqualTo(1);

    }


    @Test
    void nameTest() {
        userModel = new UserModel(1, "Celia", "Salamanca", "12345678S", "celia@gmail.com", "1233");
        assertThat(userModel.getName()).isNotNull();
        assertThat(userModel.getName()).isNotEmpty();
        assertThat(userModel.getName()).asString();
        assertThat(userModel.getName()).isEqualToIgnoringCase("CELIA");
        assertThat(userModel.getName()).isEqualTo("Celia");
        assertThat(userModel.getName()).toString();

    }


    @Test
    void surnameTest() {
        userModel = new UserModel(1, "Celia", "Salamanca", "12345678S", "celia@gmail.com", "1233");
        assertThat(userModel.getSurname()).isNotNull();
        assertThat(userModel.getSurname()).isNotEmpty();
        assertThat(userModel.getSurname()).asString();
        assertThat(userModel.getSurname()).isEqualToIgnoringCase("SALAMANCA");
        assertThat(userModel.getSurname()).isEqualTo("Salamanca");
        assertThat(userModel.getSurname()).toString();

    }


    @Test
    void dniTest() {
        userModel = new UserModel(1, "Celia", "Salamanca", "12345678S", "celia@gmail.com", "1233");
        assertThat(userModel.getDni()).isNotNull();
        assertThat(userModel.getDni()).isNotEmpty();
        assertThat(userModel.getDni()).asString();
        assertThat(userModel.getDni()).isEqualToIgnoringCase("12345678s");
        assertThat(userModel.getDni()).isEqualTo("12345678S");
        assertThat(userModel.getDni()).toString();
        assertThat(userModel.getDni()).containsPattern("^[0-9]{8}[A-Z]{1}$");

    }

    @Test
    void emailTest() {
        userModel = new UserModel(1, "Celia", "Salamanca", "12345678S", "celia@gmail.com", "1233");
        assertThat(userModel.getMail()).isNotNull();
        assertThat(userModel.getMail()).isNotEmpty();
        assertThat(userModel.getMail()).asString();
        assertThat(userModel.getMail()).isEqualToIgnoringCase("cELIA@gmail.com");
        assertThat(userModel.getMail()).isEqualTo("celia@gmail.com");
        assertThat(userModel.getMail()).toString();
        assertThat(userModel.getMail()).containsPattern("^(.+)@(.+)$");

    }

    @Test
    void passwordTest() {
        userModel = new UserModel(1, "Celia", "Salamanca", "12345678S", "celia@gmail.com", "A1233");
        assertThat(userModel.getPassword()).isNotNull();
        assertThat(userModel.getPassword()).isNotEmpty();
        assertThat(userModel.getPassword()).asString();
        assertThat(userModel.getPassword()).isEqualToIgnoringCase("a1233");
        assertThat(userModel.getPassword()).isEqualTo("A1233");
        assertThat(userModel.getPassword()).toString();


    }


}
