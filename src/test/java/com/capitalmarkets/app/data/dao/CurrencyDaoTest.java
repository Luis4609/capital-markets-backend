package com.capitalmarkets.app.data.dao;

import com.capitalmarkets.app.data.daos.ICurrencyDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
public class CurrencyDaoTest {

    @Autowired
    private ICurrencyDao currencyDao;

    @Test
    public void getByNameTest(){
        assertThat(currencyDao.getByName("Euro")).isNotNull();
        assertThat(currencyDao.getByName("Euro")).isNotEmpty();
        assertThat(currencyDao.getByName("Euro")).get().hasFieldOrProperty("code");
    }
}
