package com.capitalmarkets.app.data.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
public class CurrencyModelTestIntegration {


    @Test
    void idAutoIncrementTest() {
        CurrencyModel currencyModel1 = new CurrencyModel(1, "EUR", "euro");


        assertThat(currencyModel1.getId()).isNotZero();
        assertThat(currencyModel1.getId()).isNotNull();
        assertThat(currencyModel1.getId()).isPositive();
        assertThat(currencyModel1.getId()).isEqualTo(1);


    }

    @Test
    void nameTest() {
        CurrencyModel currencyModel = new CurrencyModel(1, "EUR", "euro");


        assertThat(currencyModel.getName()).isNotEmpty();
        assertThat(currencyModel.getName()).isNotNull();
        assertThat(currencyModel.getName()).asString();
        assertThat(currencyModel.getName()).isEqualTo("euro");
        assertThat(currencyModel.getName()).isEqualToIgnoringCase("EURO");
        assertThat(currencyModel.getName()).toString();

    }

}
