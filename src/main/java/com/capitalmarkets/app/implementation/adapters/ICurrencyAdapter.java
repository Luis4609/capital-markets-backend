package com.capitalmarkets.app.implementation.adapters;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;

import java.util.List;
import java.util.Optional;

public interface ICurrencyAdapter {

    List<CurrencyApiDTO> getAll();

    CurrencyConverterDTO getConversion(int value, String base, String conversion);

    CurrencyHistoricalDTO getHistorical(String date, int value, String base, String conversion);

}
