package com.capitalmarkets.app.implementation.service;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ApiService implements IApiService {

    //Mapper para el tratamiento del JSON proveniente de la API externa
    private ObjectMapper createObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        return objectMapper;
    }

    private MappingJackson2HttpMessageConverter createMappingJacksonHttpMessageConverter() {

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(createObjectMapper());
        return converter;
    }

    @Override
    public Map<String, String> getCurrenciesJson() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, createMappingJacksonHttpMessageConverter());

//        Currencies currencies = restTemplate.getForObject("https://api.frankfurter.app/currencies", Currencies.class);
        Map<String, String> currenciesMap = restTemplate.getForObject("https://api.frankfurter.app/currencies", Map.class);

        return currenciesMap;
    }

}
