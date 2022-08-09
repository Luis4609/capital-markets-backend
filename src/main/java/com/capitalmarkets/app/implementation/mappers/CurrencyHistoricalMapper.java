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
        JsonNode rates = objectJSON.readTree(s).get("rates");

        CurrencyHistoricalDTO  dtos=CurrencyHistoricalDTO.builder()
                                    .amount(json.get("amount").asDouble())
                                    .base(json.get("base").asText())
                                    .startDate(json.get("start_date").asText())
                                    .endDate(json.get("end_date").asText())
                                    .rates(new CurrencyRatesDTO(rates.fields().next().getValue().fields().next().getValue().asDouble()))
                                    .build();

        return dtos;
    }

    @Override
    @SneakyThrows
    public List mapListToDtoList(String s) {
        return null;
    }
}
