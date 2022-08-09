package com.capitalmarkets.app.implementation.mappers;


import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.dto.integration.CurrencyRatesDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CurrencyHistoricalMapper implements Imapper {

    private ObjectMapper objectJSON;


    @Override
    @SneakyThrows
    public CurrencyHistoricalDTO mapToDto(String s) {

        JsonNode json = objectJSON.readTree(s);
        JsonNode rates = objectJSON.readTree(s);

        CurrencyRatesDTO dtoss;

        CurrencyHistoricalDTO  dtos=CurrencyHistoricalDTO.builder()
                .amount(json.get("amount").asDouble())
                .base(json.get("base").asText())
                .startDate(json.get("start_date").asText())
                .endDate(json.get("end_date").asText())
                .rates(  dtoss = CurrencyRatesDTO.builder()
                        .result(rates.get("result").asDouble())
                        .build();
                        return dtoss;
                        )
                .build();


                        //next().getValue().toString())



        return dtos;
    }

    @Override
    @SneakyThrows
    public List mapListToDtoList(String s) {
        return null;
    }
}
