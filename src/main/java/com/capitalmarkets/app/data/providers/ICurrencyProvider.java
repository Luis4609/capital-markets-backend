package com.capitalmarkets.app.data.providers;

import com.capitalmarkets.app.data.entities.CurrencyModel;
import com.capitalmarkets.app.dto.data.CurrencyDTO;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;

public interface ICurrencyProvider {

    CurrencyDTO getCurrencyByName(String name);
    CurrencyDTO getCurrencyByCode(String code);

    CurrencyModel create(CurrencyApiDTO dto);
}
