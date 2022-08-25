package com.capitalmarkets.app.integration.adapters;

import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.dto.integration.CurrencyRatesDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest()
class ICurrencyAdapterTestIntegration {

//    @Autowired
    private ICurrencyAdapter iCurrencyAdapter;


//    @Test
    void getConversion() {
        CurrencyConverterDTO currencyConverterDTO = new CurrencyConverterDTO(10.5, "GBP", "USD", 12.3584);
        CurrencyConverterDTO result = iCurrencyAdapter.getConversion(10.5, "GBP", "USD");
        assertThat(result).isNotNull();
        assertThat(result.getTo()).isNotEmpty();
        assertThat(result.getFrom()).isNotEmpty();
        assertThat(result.getValue()).isNotInfinite();
        assertThat(result.getAmount()).isNotInfinite();
        assertThat(result.getAmount()).isNotNull();
        assertThat(result.getValue()).isNotInfinite();
        assertThat(result.getValue()).isNotNaN();
        assertThat(result.getAmount()).isNotNaN();
        assertThat(result.getAmount()).isNotNegative();
        assertThat(result.getValue()).isNotNegative();
        assertThat(result.getValue()).isEqualTo(currencyConverterDTO.getValue());
        assertThat(result.getAmount()).isEqualTo(currencyConverterDTO.getAmount());
        assertThat(result.getFrom()).isEqualTo(currencyConverterDTO.getFrom());
        assertThat(result.getTo()).isEqualTo(currencyConverterDTO.getTo());
    }

//    @Test
    void getHistorical() {
        List<CurrencyRatesDTO> rates = new ArrayList<CurrencyRatesDTO>();
        CurrencyRatesDTO currencyRatesDTO = new CurrencyRatesDTO("2022-08-23", 4.2172);
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(5.0, "EUR", "GBP", "4.2172", "2022-08-23", "2022-08-23", rates);
        CurrencyHistoricalDTO result = iCurrencyAdapter.getHistorical("2022-08-23", 5, "EUR", "GBP");
        assertThat(result).isNotNull();
        assertThat(result.getTo()).isNotEmpty();
        assertThat(result.getBase()).isNotEmpty();
        assertThat(result.getConversion()).isNotEmpty();
        assertThat(result.getTo()).isNotEmpty();
        assertThat(result.getStartDate()).isNotEmpty();
        assertThat(result.getEndDate()).isNotEmpty();
        assertThat(result.getRates()).isNotEmpty();
        assertThat(result.getAmount()).isNotInfinite();
        assertThat(result.getAmount()).isNotNull();
        assertThat(result.getAmount()).isNotNaN();
        assertThat(result.getAmount()).isNotNegative();
        assertThat(result.getRates()).isNotNull();
        assertThat(result.getRates()).asList();
        assertThat(result.getRates()).isEqualTo(currencyHistoricalDTO.getRates());
        assertThat(result.getTo()).asString();
        assertThat(result.getTo()).isEqualTo(currencyHistoricalDTO.getTo());
        assertThat(result.getTo()).hasSameSizeAs(result.getTo());
        assertThat(result.getBase()).asString();
        assertThat(result.getBase()).isEqualTo(currencyHistoricalDTO.getBase());
        assertThat(result.getBase()).hasSameSizeAs(result.getBase());
        assertThat(result.getBase()).hasSize(3);
        assertThat(result.getEndDate()).asString();
        assertThat(result.getEndDate()).isEqualTo(currencyHistoricalDTO.getEndDate());
        assertThat(result.getEndDate()).hasSameSizeAs(result.getEndDate());
        assertThat(result.getStartDate()).asString();
        assertThat(result.getStartDate()).isEqualTo(currencyHistoricalDTO.getStartDate());
        assertThat(result.getStartDate()).hasSameSizeAs(result.getStartDate());
        assertThat(result.getAmount()).isEqualTo(currencyHistoricalDTO.getAmount());
        assertThat(result.getConversion()).asString();
        assertThat(result.getConversion()).isEqualTo(currencyHistoricalDTO.getConversion());
        assertThat(result.getConversion()).hasSameSizeAs(result.getConversion());
    }

//    @Test
    void getInterval() {
        List<CurrencyRatesDTO> rates = new ArrayList<CurrencyRatesDTO>();
        CurrencyRatesDTO currencyRatesDTO = new CurrencyRatesDTO("2022-08-23", 25.489);
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(30.0, "USD", "GBP", "25.489", "2022-08-23", "2022-08-23", rates);
        CurrencyHistoricalDTO result = iCurrencyAdapter.getInterval("2022-08-23", "2022-08-24", 30, "USD", "GBP");
        assertThat(result).isNotNull();
        assertThat(result.getTo()).isNotEmpty();
        assertThat(result.getBase()).isNotEmpty();
        assertThat(result.getConversion()).isNotEmpty();
        assertThat(result.getTo()).isNotEmpty();
        assertThat(result.getStartDate()).isNotEmpty();
        assertThat(result.getEndDate()).isNotEmpty();
        assertThat(result.getRates()).isNotEmpty();
        assertThat(result.getAmount()).isNotInfinite();
        assertThat(result.getAmount()).isNotNull();
        assertThat(result.getAmount()).isNotNaN();
        assertThat(result.getAmount()).isNotNegative();
        assertThat(result.getRates()).isNotNull();
        assertThat(result.getRates()).asList();
        assertThat(result.getRates()).isEqualTo(currencyHistoricalDTO.getRates());
        assertThat(result.getTo()).asString();
        assertThat(result.getTo()).isEqualTo(currencyHistoricalDTO.getTo());
        assertThat(result.getTo()).hasSameSizeAs(result.getTo());
        assertThat(result.getBase()).asString();
        assertThat(result.getBase()).isEqualTo(currencyHistoricalDTO.getBase());
        assertThat(result.getBase()).hasSameSizeAs(result.getBase());
        assertThat(result.getBase()).hasSize(3);
        assertThat(result.getEndDate()).asString();
        assertThat(result.getEndDate()).isEqualTo(currencyHistoricalDTO.getEndDate());
        assertThat(result.getEndDate()).hasSameSizeAs(result.getEndDate());
        assertThat(result.getStartDate()).asString();
        assertThat(result.getStartDate()).isEqualTo(currencyHistoricalDTO.getStartDate());
        assertThat(result.getStartDate()).hasSameSizeAs(result.getStartDate());
        assertThat(result.getAmount()).isEqualTo(currencyHistoricalDTO.getAmount());
        assertThat(result.getConversion()).asString();
        assertThat(result.getConversion()).isEqualTo(currencyHistoricalDTO.getConversion());
        assertThat(result.getConversion()).hasSameSizeAs(result.getConversion());
    }
}