package com.capitalmarkets.app.dto.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class CurrencyHistoricalDTOTestIntegration {

    private List<CurrencyRatesDTO> rates = new ArrayList<CurrencyRatesDTO>();
    private CurrencyRatesDTO currencyRatesDTO = new CurrencyRatesDTO("2022-08-23", 4.2172);

    @Test
    void amountTest() {
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(5.0, "EUR", "GBP", "4.2172", "2022-08-23", "2022-08-23", rates);
        assertThat(currencyHistoricalDTO.getAmount()).isNotNull();
        assertThat(currencyHistoricalDTO.getAmount()).isNotNegative();
        assertThat(currencyHistoricalDTO.getAmount()).isNotNaN();
        assertThat(currencyHistoricalDTO.getAmount()).isNotInfinite();
        assertThat(currencyHistoricalDTO.getAmount()).isGreaterThanOrEqualTo(0);
        assertThat(currencyHistoricalDTO.getAmount()).isEqualTo(5.0);
        assertThat(currencyHistoricalDTO.getAmount()).toString();


    }

    @Test
    void baseTest() {
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(5.0, "EUR", "GBP",
                "4.2172", "2022-08-23", "2022-08-23", rates);
        assertThat(currencyHistoricalDTO.getBase()).asString();
        assertThat(currencyHistoricalDTO.getBase()).isNotEmpty();
        assertThat(currencyHistoricalDTO.getBase()).isNotNull();
        assertThat(currencyHistoricalDTO.getBase()).isEqualToIgnoringCase("EUr");
        assertThat(currencyHistoricalDTO.getBase()).isEqualTo("EUR");
        assertThat(currencyHistoricalDTO.getBase()).toString();
        assertThat(currencyHistoricalDTO.getBase()).hasSize(3);
    }

    @Test
    void toTest() {
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(5.0, "EUR", "GBP", "4.2172", "2022-08-23", "2022-08-23", rates);
        assertThat(currencyHistoricalDTO.getTo()).asString();
        assertThat(currencyHistoricalDTO.getTo()).isNotEmpty();
        assertThat(currencyHistoricalDTO.getTo()).isNotNull();
        assertThat(currencyHistoricalDTO.getTo()).isEqualToIgnoringCase("gbp");
        assertThat(currencyHistoricalDTO.getTo()).isEqualTo("GBP");
        assertThat(currencyHistoricalDTO.getTo()).toString();
        assertThat(currencyHistoricalDTO.getTo()).hasSize(3);
    }

    @Test
    void conversionTest() {
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(5.0, "EUR", "GBP", "4.2172", "2022-08-23", "2022-08-23", rates);
        assertThat(currencyHistoricalDTO.getConversion()).asString();
        assertThat(currencyHistoricalDTO.getConversion()).isNotEmpty();
        assertThat(currencyHistoricalDTO.getConversion()).isNotNull();
        assertThat(currencyHistoricalDTO.getConversion()).isEqualTo("4.2172");
        assertThat(currencyHistoricalDTO.getConversion()).toString();
    }

    @Test
    void startDateTest() {
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(5.0, "EUR", "GBP", "4.2172",
                "2022-08-23", "2022-08-23", rates);
        assertThat(currencyHistoricalDTO.getStartDate()).asString();
        assertThat(currencyHistoricalDTO.getStartDate()).isNotEmpty();
        assertThat(currencyHistoricalDTO.getStartDate()).isNotNull();
        assertThat(currencyHistoricalDTO.getStartDate()).isEqualTo("2022-08-23");
        assertThat(currencyHistoricalDTO.getStartDate()).toString();
    }


    @Test
    void endDateTest() {
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(5.0, "EUR", "GBP", "4.2172",
                "2022-08-23", "2022-08-23", rates);
        assertThat(currencyHistoricalDTO.getEndDate()).asString();
        assertThat(currencyHistoricalDTO.getEndDate()).isNotEmpty();
        assertThat(currencyHistoricalDTO.getEndDate()).isNotNull();
        assertThat(currencyHistoricalDTO.getEndDate()).isEqualTo("2022-08-23");
        assertThat(currencyHistoricalDTO.getEndDate()).toString();
    }


    @Test
    void ratesTest() {
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(5.0, "EUR", "GBP", "4.2172",
                "2022-08-23", "2022-08-23", rates);
        assertThat(currencyHistoricalDTO.getRates()).asString();
        assertThat(currencyHistoricalDTO.getRates()).isNotEmpty();
        assertThat(currencyHistoricalDTO.getRates()).isNotNull();
        assertThat(currencyHistoricalDTO.getRates()).isEqualTo(rates);
        assertThat(currencyHistoricalDTO.getEndDate()).toString();
    }
}