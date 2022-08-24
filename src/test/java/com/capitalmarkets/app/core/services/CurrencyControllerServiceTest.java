package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.dto.integration.CurrencyRatesDTO;
import com.capitalmarkets.app.integration.adapters.services.IcurrencyService;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
@ExtendWith(MockitoExtension.class)
class CurrencyControllerServiceTest {

    @Mock
    private IcurrencyService service;

    @InjectMocks
    private CurrencyControllerService currencyControllerService;
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
    void getAll() {
        currenciesList = new ArrayList<>();
        currenciesList.add(new CurrencyApiDTO("EUR", "Euro"));
        currenciesList.add(new CurrencyApiDTO("AUD", "Australian Dollar"));
        Mockito.when(service.getAll()).thenReturn(currenciesList);
        List<CurrencyApiDTO> result = currencyControllerService.getAll();
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
        Mockito.when(service.getConversion(100, "EUR", "AUD")).thenReturn(currencyConverterDTO);
        CurrencyConverterDTO result = currencyControllerService.getConversion(100, "EUR", "AUD");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(currencyConverterDTO, result);
        Assertions.assertInstanceOf(CurrencyConverterDTO.class, result);


    }

    @Test
    void getHistorical() {
        Mockito.when(service.getHistorical("2022-01-01", 100, "EUR", "AUD")).thenReturn(currencyHistoricalDTO);
        CurrencyHistoricalDTO result = currencyControllerService.getHistorical("2022-01-01", 100, "EUR", "AUD");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(currencyHistoricalDTO, result);
        Assertions.assertInstanceOf(CurrencyHistoricalDTO.class, result);
    }

    @Test
    void getInterval() {
        Mockito.when(service.getInterval("2022-01-01", "2022-01-15", 30, "USD", "GBP")).thenReturn(currencyHistoricalDTO);
        CurrencyHistoricalDTO result = currencyControllerService.getInterval("2022-01-01", "2022-01-15", 30, "USD", "GBP");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(currencyHistoricalDTO, result);
        Assertions.assertInstanceOf(CurrencyHistoricalDTO.class, result);
    }
}