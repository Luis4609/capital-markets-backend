package com.capitalmarkets.app.implementation.mappers;

import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class CurrencyConverterMapper implements Imapper<CurrencyConverterDTO> {

    private ObjectMapper objectJSON;

    @SneakyThrows
    @Override
    public CurrencyConverterDTO mapToDto(String s) {


        JsonNode json = objectJSON.readTree(s);
        JsonNode rates = json.get("rates");

        CurrencyConverterDTO dto= CurrencyConverterDTO.builder()
                .amount(json.get("amount").asDouble())
                .from(json.get("base").asText())
                .to(rates.fields().next().getKey())
                .date(json.get("date").asText())
                .value(rates.fields().next().getValue().asDouble())
                .build();

        return dto;
    }

    @Override
    public List<CurrencyConverterDTO> mapListToDtoList(String s) {throw new UnsupportedOperationException();}


}
