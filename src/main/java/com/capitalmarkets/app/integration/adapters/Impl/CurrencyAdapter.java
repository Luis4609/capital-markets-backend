package com.capitalmarkets.app.integration.adapters.Impl;

import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.integration.adapters.ICurrencyAdapter;
import com.capitalmarkets.app.integration.mappers.Imapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    public CurrencyConverterDTO getConversion(double value, String base, String conversion) {

        restTemplate.getForObject(url+"latest?amount="+value+"&from="+base+"&to="+conversion,String.class);
        log.info(restTemplate.getForObject(url+"latest?amount="+value+"&from="+base+"&to="+conversion,String.class));

        return mapConv.mapToDto(restTemplate.getForObject(url+"latest?amount="+value+"&from="+base+"&to="+conversion,String.class));
    }

    @Override
    public CurrencyHistoricalDTO getHistorical(String date, double value, String base, String conversion) {

        restTemplate.getForObject(url+date+"..?amount="+value+"&from="+base+"&to="+conversion,String.class);
        log.info(restTemplate.getForObject(url+date+"..?amount="+value+"&from="+base+"&to="+conversion,String.class));


        return mapHist.mapToDto(restTemplate.getForObject(url+date+"..?amount="+value+"&from="+base+"&to="+conversion,String.class));
    }

    @Override
    public CurrencyHistoricalDTO getInterval(String start, String end,double value, String base,String conversion) {


        restTemplate.getForObject(url+start+".."+end+"?amount="+value+"&from="+base+"&to="+conversion,String.class,String.class);

        return mapHist.mapToDto(restTemplate.getForObject(url+start+".."+end+"?amount="+value+"&from="+base+"&to="+conversion,String.class,String.class));
    }

}
