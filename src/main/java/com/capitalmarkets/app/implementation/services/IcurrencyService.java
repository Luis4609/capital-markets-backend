package com.capitalmarkets.app.implementation.services;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;

import java.util.List;

public interface IcurrencyService {

    List<CurrencyApiDTO> getAll();

    CurrencyConverterDTO getConversion(int value, String base, String conversion);
    CurrencyHistoricalDTO getHistorical(String date, int value, String base, String conversion);
}
