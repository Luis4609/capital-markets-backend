package com.capitalmarkets.app;

import com.capitalmarkets.app.data.daos.ICurrencyDao;
import com.capitalmarkets.app.data.entities.CurrencyModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import java.util.Optional;

@SpringBootTest()
public class ICurrencyDaoTest {





    @Autowired
    private ICurrencyDao iCurrencyDao;

    @Test
    void currencyGetByNameTest() {
        CurrencyModel currencyModel = new CurrencyModel(1, "EUR", "euro");
        assertThat(currencyModel).isNotNull();
        assertThat(currencyModel.getCode()).isNotNull();
        assertThat(currencyModel.getName()).isEqualToIgnoringCase("EURO");
        assertThat(currencyModel.getCode()).isNotEmpty();
        assertThat(currencyModel.getName()).isEqualTo("euro");
        assertThat(currencyModel.getCode()).isEqualTo("EUR");

        //org.junit.jupiter.api.Assertions.assertEquals(Optional.of(currencyModel), iCurrencyDao.getByName("euro"));
    }

    @Test
    void currencyGetByCodeTest(){
        CurrencyModel currencyModel = new CurrencyModel( 1, "EUR", "euro");
        assertThat(currencyModel).isNotNull();
        assertThat(currencyModel.getName()).isNotNull();
        assertThat(currencyModel.getCode()).isEqualTo("euro");
        assertThat(currencyModel.getCode()).isEqualTo("EUR");
        assertThat(currencyModel.getName()).isNotEmpty();
        assertThat(currencyModel.getCode()).isEqualToIgnoringCase("eur");

    }

    



}