package com.capitalmarkets.app.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currencies")
public class CurrencyRestController {

    @GetMapping("/list-string")
    public String getCurrenciesList() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity("https://api.frankfurter.app/currencies", String.class);
        return response.getBody();
    }

}
