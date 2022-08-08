package com.capitalmarkets.app.data.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest()
public class CurrencyModelTest {



    @Test
     void idAutoIncrementTest(){
        CurrencyModel currencyModel1 = new CurrencyModel( 1, "EUR", "euro");

        assertThat(currencyModel1.getId()).isEqualTo(1);
        assertThat(currencyModel1.getId()).isNotZero();

    }
    @Test
    void nameTest(){
        CurrencyModel currencyModel = new CurrencyModel(1, "EUR", "euro");

        assertThat(currencyModel.getName()).isEqualTo("euro");
        //assertThat(currencyModel.setName("pepe")).isEqualTo("euro");
    }

}
