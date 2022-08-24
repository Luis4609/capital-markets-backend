package com.capitalmarkets.app.data.daos;


import com.capitalmarkets.app.data.entities.CurrencyModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest()
public class ICurrencyDaoTestIntegration {
    @Autowired
    private ICurrencyDao iCurrencyDao;

    @Test
    void currencyGetByNameTest() {
        CurrencyModel currencyModel = new CurrencyModel(1, "EUR", "euro");
        assertThat(currencyModel).isNotNull();
        assertThat(currencyModel.getCode()).isNotNull();
        assertThat(currencyModel.getName()).isEqualToIgnoringCase("EURO");
        assertThat(currencyModel.getName()).asString();
        assertThat(currencyModel.getCode()).isNotEmpty();
        assertThat(currencyModel.getCode()).hasSize(3);
        assertThat(currencyModel.getName()).isEqualTo("euro");
        assertThat(currencyModel.getCode()).isEqualTo("EUR");
        assertThat(currencyModel.getCode()).toString();
        assertThat(currencyModel.getCode()).asString();

    }

    @Test
    void currencyGetByCodeTest() {
        CurrencyModel currencyModel = new CurrencyModel(1, "EUR", "euro");
        assertThat(currencyModel).isNotNull();
        assertThat(currencyModel.getName()).isNotNull();
        assertThat(currencyModel.getName()).isEqualTo("euro");
        assertThat(currencyModel.getCode()).isNotEmpty();
        assertThat(currencyModel.getCode()).asString();
        assertThat(currencyModel.getName()).asString();
        assertThat(currencyModel.getCode()).isEqualTo("EUR");
        assertThat(currencyModel.getCode()).hasSize(3);
        assertThat(currencyModel.getName()).isNotEmpty();
        assertThat(currencyModel.getCode()).isEqualToIgnoringCase("eur");

    }


}