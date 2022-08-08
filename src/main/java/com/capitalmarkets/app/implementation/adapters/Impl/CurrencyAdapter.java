package com.capitalmarkets.app.implementation.adapters.Impl;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.implementation.adapters.ICurrencyAdapter;
import com.capitalmarkets.app.implementation.mappers.Imapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class CurrencyAdapter implements ICurrencyAdapter {


    private static final String url="https://api.frankfurter.app/";

    private final RestTemplate restTemplate = new RestTemplate();
    private final Imapper<CurrencyApiDTO> mapper;
    private final Imapper<CurrencyConverterDTO> mapConv;
    private final Imapper<CurrencyHistoricalDTO> mapHist;


    @Override
    public List<CurrencyApiDTO> getAll() {

        restTemplate.getForObject(url+"currencies",String.class);
        log.info(restTemplate.getForObject(url+"currencies",String.class));

        return mapper.mapListToDtoList(restTemplate.getForObject(url+"currencies",String.class));
    }


    @Override
    public CurrencyConverterDTO getConversion(int value, String base, String conversion) {

        restTemplate.getForObject(url+"latest?amount="+value+"&from="+base+"&to="+conversion,String.class);
        log.info(restTemplate.getForObject(url+"latest?amount="+value+"&from="+base+"&to="+conversion,String.class));

        return mapConv.mapToDto(restTemplate.getForObject(url+"latest?amount="+value+"&from="+base+"&to="+conversion,String.class));
    }

    @Override
    public CurrencyHistoricalDTO getHistorical(String date, int value, String base, String conversion) {

        restTemplate.getForObject(url+date+"..?amount="+value+"&from="+base+"&to="+conversion,String.class);
        log.info(restTemplate.getForObject(url+date+"..?amount="+value+"&from="+base+"&to="+conversion,String.class));

        return mapHist.mapToDto(restTemplate.getForObject(url+date+"..?amount="+value+"&from="+base+"&to="+conversion,String.class));
    }


}
