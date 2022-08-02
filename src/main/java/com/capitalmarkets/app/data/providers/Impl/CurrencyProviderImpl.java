package com.capitalmarkets.app.data.providers.Impl;

import com.capitalmarkets.app.data.daos.ICurrencyDao;
import com.capitalmarkets.app.data.entities.CurrencyModel;
import com.capitalmarkets.app.data.mappers.Imapper;
import com.capitalmarkets.app.data.providers.ICurrencyProvider;
import com.capitalmarkets.app.dto.CurrencyDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyProviderImpl implements ICurrencyProvider {

    private final ICurrencyDao currencyDao;
    private final Imapper<CurrencyModel,CurrencyDTO> mapper;

    @Override
    public CurrencyDTO getCurrencyByName(String name) {
        return currencyDao.findByName(name)
                .map(mapper::mapToDto)
                .orElse(null);
    }

    @Override
    public CurrencyDTO getCurrencyByCode(String code) {
        return currencyDao.getByCurrencyCode(code)
                .map(mapper::mapToDto)
                .orElse(null);
    }



}
