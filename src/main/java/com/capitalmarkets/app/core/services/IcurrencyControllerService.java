package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;

import java.util.List;

public interface IcurrencyControllerService {

    List<CurrencyApiDTO> getAll();
    CurrencyConverterDTO getConversion(double value, String base, String conversion);
    CurrencyHistoricalDTO getHistorical(String date, double value, String base, String conversion);
    CurrencyHistoricalDTO getInterval(String start, String end,double value, String base,String conversion);
}
