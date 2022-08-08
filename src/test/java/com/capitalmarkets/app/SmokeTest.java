package com.capitalmarkets.app;

import static org.assertj.core.api.Assertions.assertThat;

import com.capitalmarkets.app.core.controller.CurrencyRestController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private CurrencyRestController currencyRestController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(currencyRestController.getCurrenciesList()).isNotNull();
        assertThat(currencyRestController.getCurrenciesList()).isNotEmpty();
        assertThat(currencyRestController.getCurrenciesList()).contains("Australian Dollar");
    }
}