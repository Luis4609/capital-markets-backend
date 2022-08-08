package com.capitalmarkets.app.data.providers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest()
public class ICurrencyProviderTest {

    @Autowired
    private ICurrencyProvider iCurrencyProvider;

    @Test
    public void getCurrencyByCodeShouldNotBeNull() throws Exception {
        assertThat(iCurrencyProvider.getCurrencyByCode("EUR")).isNotNull();
    }

    @Test
    public void getCurrencyByNameShouldNotBeNull() throws Exception {
        assertThat(iCurrencyProvider.getCurrencyByName("euro")).isNotNull();
    }
}
