package com.capitalmarkets.app.integration.mappers;

import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;

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
                .value(rates.fields().next().getValue().asDouble())
                .build();

        return dto;
    }



    @Override
    public List<CurrencyConverterDTO> mapListToDtoList(String s) {throw new UnsupportedOperationException();}


}
