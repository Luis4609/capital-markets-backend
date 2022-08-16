package com.capitalmarkets.app.integration.adapters.services;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.integration.adapters.ICurrencyAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyService implements IcurrencyService{

    private final ICurrencyAdapter iCurrencyAdapter;

    @Override
    public List<CurrencyApiDTO> getAll() {
        return iCurrencyAdapter.getAll();
    }

    @Override
    public CurrencyConverterDTO getConversion(double value, String base, String conversion) {
        return iCurrencyAdapter.getConversion(value, base, conversion);
    }
    @Override
    public CurrencyHistoricalDTO getHistorical(String date, double value, String base, String conversion){
        return iCurrencyAdapter.getHistorical(date, value, base, conversion);
    }

    @Override
    public CurrencyHistoricalDTO getInterval(String start, String end,double value, String base, String conversion) {
        return iCurrencyAdapter.getInterval(start, end,value,base,conversion);
    }
}
