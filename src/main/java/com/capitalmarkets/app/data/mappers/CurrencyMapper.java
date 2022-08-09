package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.CurrencyModel;
import com.capitalmarkets.app.dto.data.CurrencyDTO;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper implements Imapper<CurrencyModel, CurrencyDTO> {


    @Override
    public CurrencyDTO mapToDto(CurrencyModel currencyModel) {

        CurrencyDTO dto = new CurrencyDTO(currencyModel.getCode(), currencyModel.getName());

        return dto;
    }

    @Override
    public CurrencyModel mapToEntity(CurrencyDTO currencyDTO) {

        CurrencyModel cm = new CurrencyModel(0, currencyDTO.getCode(), currencyDTO.getName());

        return cm;
    }
}
