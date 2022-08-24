package com.capitalmarkets.app.dto.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class CurrencyApiDTOTestIntegration {

    private CurrencyApiDTO currencyApiDTO=new CurrencyApiDTO("EUR","euro");

    @Test
    void codeTest(){
        assertThat(currencyApiDTO.getCode()).asString();
        assertThat(currencyApiDTO.getCode()).isNotEmpty();
        assertThat(currencyApiDTO.getCode()).isNotNull();
        assertThat(currencyApiDTO.getCode()).isEqualToIgnoringCase("eur");
        assertThat(currencyApiDTO.getCode()).isEqualTo("EUR");
        assertThat(currencyApiDTO.getCode()).toString();
        assertThat(currencyApiDTO.getCode()).hasSize(3);
    }

    @Test
    void nameTest(){
        assertThat(currencyApiDTO.getName()).asString();
        assertThat(currencyApiDTO.getName()).isNotEmpty();
        assertThat(currencyApiDTO.getName()).isNotNull();
        assertThat(currencyApiDTO.getName()).isEqualToIgnoringCase("Euro");
        assertThat(currencyApiDTO.getName()).isEqualTo("euro");
        assertThat(currencyApiDTO.getName()).toString();

    }


}