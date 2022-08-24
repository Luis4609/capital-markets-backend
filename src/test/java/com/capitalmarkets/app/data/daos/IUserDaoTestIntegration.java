package com.capitalmarkets.app.data.daos;

import com.capitalmarkets.app.data.entities.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest()
public class IUserDaoTestIntegration {

    @Autowired
    private  IUserDao iUserDao;

    @Test //OK
    void  userGetByDni(){
      UserModel userModel=new UserModel(0,"Celia","Salamanca","69696969T","celia@email.com","1234");
      Optional<UserModel> userModelOptional = iUserDao.getByDni("69696969T");

        assertThat(userModelOptional.get().getDni()).isNotNull();
        assertThat(userModelOptional.get().getDni()).isNotEmpty();
        assertThat(userModelOptional.get().getDni()).hasSize(9);
        assertThat(userModelOptional.get().getDni()).containsPattern( "^[0-9]{8}[A-Z]{1}$");
        assertThat(userModelOptional.get().getDni()).isEqualTo(userModel.getDni());
        assertThat(userModelOptional.get().getDni()).isEqualToIgnoringCase(userModel.getDni());
    }


    @Test //OK
    void userGetByMail(){
        UserModel userModel=new UserModel(0,"Celia","Salamanca","69696969T","celia@email.com","1232");
        Optional<UserModel> userTest=iUserDao.getByMail("celia@email.com");

        assertThat(userTest).isNotNull();
        assertThat(userTest).isNotEmpty();
        assertThat(userTest.get().getMail()).isNotNull();
        assertThat(userTest.get().getMail()).isNotEmpty();
        assertThat(userTest.get().getMail()).isEqualToIgnoringCase("celia@email.com");
        assertThat(userTest.get().getMail()).containsPattern("^(.+)@(.+)$");
        assertThat(userTest.get().getMail()).isEqualTo(userModel.getMail());
        assertThat(userTest.get().getDni()).isEqualTo(userModel.getDni());

    }
}
