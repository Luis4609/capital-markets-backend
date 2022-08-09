package com.capitalmarkets.app.data.providers.Impl;

import com.capitalmarkets.app.data.daos.ICurrencyDao;
import com.capitalmarkets.app.data.entities.CurrencyModel;
import com.capitalmarkets.app.data.mappers.Imapper;
import com.capitalmarkets.app.data.providers.ICurrencyProvider;
import com.capitalmarkets.app.dto.data.CurrencyDTO;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyProviderImpl implements ICurrencyProvider {

    private final ICurrencyDao currencyDao;
    private final Imapper<CurrencyModel,CurrencyDTO> mapper;

    @Override
    public CurrencyDTO getCurrencyByName(String name) {
        return currencyDao.getByName(name)
                .map(mapper::mapToDto)
                .orElse(new CurrencyDTO("No se ha encontrado ese nombre"));
    }

    @Override
    public CurrencyDTO getCurrencyByCode(String code) {
        return currencyDao.getByCode(code)
                .map(mapper::mapToDto)
                .orElse(new CurrencyDTO("No se ha encontrado ese codigo"));
    }

    /*ESTE METODO NO SE USA EN NINGUN LUGAR*/
//    public Collection<CurrencyDTO> getAll() {
//
//        return currencyDao.findAll().stream()
//                .map(mapper::mapToDto)
//                .collect(Collectors.toList());
//    }


    public CurrencyModel create(CurrencyApiDTO dto){

        CurrencyModel dto1=CurrencyModel.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .build();

        return currencyDao.save(dto1);
    }

}
