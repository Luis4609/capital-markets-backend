package com.capitalmarkets.app.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
public class CurrencyRestController {

    @GetMapping("/andres")
    public String getAndresCoin(){

        return "Andres";
    }

}
