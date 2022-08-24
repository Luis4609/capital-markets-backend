package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IcurrencyControllerService;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.dto.integration.CurrencyRatesDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
@ExtendWith(MockitoExtension.class)
class CurrencyRestControllerTest {

    @Mock
    private IcurrencyControllerService controllerService;

    @InjectMocks
    private CurrencyRestController currencyRestController;

    @Mock
    private List<CurrencyApiDTO> currenciesList;
    @Mock
    private CurrencyConverterDTO currencyConverterDTO;
    @Mock
    private CurrencyHistoricalDTO currencyHistoricalDTO;


    @BeforeEach
    void setUp() {
        List<CurrencyRatesDTO> rates = new ArrayList<CurrencyRatesDTO>();
        CurrencyRatesDTO currencyRatesDTO = new CurrencyRatesDTO("2022-08-22", 4.2329);
        rates.add(currencyRatesDTO);
        CurrencyHistoricalDTO currencyHistoricalDTO = new CurrencyHistoricalDTO(5.0, "EUR", "GBP", "4.2329", "2022-08-22", "2022-08-22", rates);


    }

    @Test
    void getCurrenciesList() {
        currenciesList = new ArrayList<>();
        currenciesList.add(new CurrencyApiDTO("EUR", "Euro"));
        currenciesList.add(new CurrencyApiDTO("AUD", "Australian Dollar"));
        Mockito.when(controllerService.getAll()).thenReturn(currenciesList);
        List<CurrencyApiDTO> result = currencyRestController.getCurrenciesList();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(currenciesList, result);


    }

    @Test
    void getConversion() {
        currencyConverterDTO = new CurrencyConverterDTO();
        currencyConverterDTO.setAmount(100);
        currencyConverterDTO.setFrom("EUR");
        currencyConverterDTO.setTo("AUD");
        currencyConverterDTO.setValue(145.84);
        Mockito.when(controllerService.getConversion(100, "EUR", "AUD")).thenReturn(currencyConverterDTO);
        CurrencyConverterDTO result = currencyRestController.getConversion(100, "EUR", "AUD");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(currencyConverterDTO, result);
        Assertions.assertInstanceOf(CurrencyConverterDTO.class, result);


    }

    @Test
    void getHistorical() throws IOException {

        Mockito.when(controllerService.getHistorical("2022-01-01", 100, "EUR", "AUD")).thenReturn(currencyHistoricalDTO);
        CurrencyHistoricalDTO result = currencyRestController.getHistorical("2022-01-01", 100, "EUR", "AUD");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(currencyHistoricalDTO, result);
        Assertions.assertInstanceOf(CurrencyHistoricalDTO.class, result);

    }

    @Test
    void getInterval() {
        Mockito.when(controllerService.getInterval("2022-01-01", "2022-01-15", 30, "USD", "GBP")).thenReturn(currencyHistoricalDTO);
        CurrencyHistoricalDTO result = currencyRestController.getInterval("2022-01-01", "2022-01-15", 30, "USD", "GBP");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(currencyHistoricalDTO, result);
        Assertions.assertInstanceOf(CurrencyHistoricalDTO.class, result);
    }


}