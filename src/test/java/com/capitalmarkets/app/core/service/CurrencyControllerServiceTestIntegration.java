package com.capitalmarkets.app.core.service;

import com.capitalmarkets.app.core.controller.CurrencyRestController;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest()
public class CurrencyControllerServiceTestIntegration {

    @Autowired
    private CurrencyRestController currencyRestController;


    @Test
    public void currenciesListTestOK() {
        CurrencyApiDTO currencyApiDTO = new CurrencyApiDTO("EUR", "euro");
        assertThat(currencyApiDTO).isNotNull();
        assertThat(currencyApiDTO.getName()).isEqualTo("euro");
        assertThat(currencyApiDTO.getCode()).isEqualTo("EUR");
        assertThat(currencyApiDTO.getCode()).hasSize(3);
        assertThat(currencyApiDTO.getName()).isNotEmpty();
        assertThat(currencyApiDTO.getCode()).isNotEmpty();
    }

    @Test
    public void conversionTestOK() {
        CurrencyConverterDTO currencyConverterDTO = new CurrencyConverterDTO(20,"EUR",  "USD",21.50);
        assertThat(currencyConverterDTO).isNotNull();
        assertThat(currencyConverterDTO.getAmount()).isEqualTo(20);
        assertThat(currencyConverterDTO.getFrom()).isEqualTo("EUR");
        assertThat(currencyConverterDTO.getTo()).isEqualTo("USD");
        assertThat(currencyConverterDTO.getValue()).isEqualTo(21.50);
        assertThat(currencyConverterDTO.getAmount()).hasFieldOrPropertyWithValue("USD", 21.50);
    }

    @Test
    public void historicalTestOK() {
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(20, "EUR", "USD", "2021/07/19", "2022/07/19", null );
        assertThat(currencyHistoricalDTO).isNotNull();
        assertThat(currencyHistoricalDTO.getAmount()).isEqualTo(20);
        assertThat(currencyHistoricalDTO.getBase()).isEqualTo("EUR");
        assertThat(currencyHistoricalDTO.getStartDate()).isEqualTo("2021/07/19");
        assertThat(currencyHistoricalDTO.getEndDate()).isEqualTo("2022/07/19");
        assertThat(currencyHistoricalDTO.getRates()).isNull();
        assertThat(currencyHistoricalDTO.getStartDate()).hasSize(10);
        assertThat(currencyHistoricalDTO.getEndDate()).hasSize(10);
    }
}