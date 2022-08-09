package com.capitalmarkets.app.integration.mappers;


import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CurrenciesMapper implements Imapper<CurrencyApiDTO>{

    private ObjectMapper objectJSON;

    @SneakyThrows
    @Override
    public CurrencyApiDTO mapToDto(String s) {
        throw new UnsupportedOperationException();
    }

    @SneakyThrows
    @Override
    public List<CurrencyApiDTO> mapListToDtoList(String s) {
        List<CurrencyApiDTO> dtos = new ArrayList<>();

        JsonNode json = objectJSON.readTree(s);

        json.fields().forEachRemaining(node -> {
            dtos.add(
                    CurrencyApiDTO.builder()
                            .code(node.getKey())
                            .name(node.getValue().asText())
                            .build()
            );
        });

        return dtos;
    }



}
