package com.capitalmarkets.app.core.services;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.integration.adapters.services.IcurrencyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CurrencyControllerService implements IcurrencyControllerService {

    private final IcurrencyService servicio;

    @Override
    public List<CurrencyApiDTO> getAll() {
        return servicio.getAll();
    }

    @Override
    public CurrencyConverterDTO getConversion(double value, String base, String conversion) {
        return servicio.getConversion(value, base, conversion);
    }

    @Override
    public CurrencyHistoricalDTO getHistorical(String date, double value, String base, String conversion) {
        return servicio.getHistorical(date, value, base, conversion);
    }

    @Override
    public CurrencyHistoricalDTO getInterval(String start, String end, double value, String base, String conversion) {
        return servicio.getInterval(start, end, value, base, conversion);
    }
}
