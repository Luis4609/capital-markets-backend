package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.implementation.services.IcurrencyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CurrencyControllerService implements IcurrencyControllerService{

    private final IcurrencyService servicio;

    @Override
    public List<CurrencyApiDTO> getAll() {
        return servicio.getAll();
    }

    @Override
    public CurrencyConverterDTO getConversion(int value, String base, String conversion) {
        return servicio.getConversion(value,base,conversion);
    }

    @Override
    public CurrencyHistoricalDTO getHistorical(String date, int value, String base, String conversion){
        return servicio.getHistorical(date, value, base, conversion);
    }
}
