package com.capitalmarkets.app.implementation.services;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.implementation.adapters.ICurrencyAdapter;
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
    public CurrencyConverterDTO getConversion(int value, String base, String conversion) {
        return iCurrencyAdapter.getConversion(value, base, conversion);
    }
}
