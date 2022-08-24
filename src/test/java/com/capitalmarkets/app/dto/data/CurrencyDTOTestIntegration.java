package com.capitalmarkets.app.dto.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class CurrencyDTOTestIntegration {

    private CurrencyDTO currencyDTO = new CurrencyDTO("EUR", "euro");


    @Test
    void codeTest() {
        assertThat(currencyDTO.getCode()).asString();
        assertThat(currencyDTO.getCode()).isNotEmpty();
        assertThat(currencyDTO.getCode()).isNotNull();
        assertThat(currencyDTO.getCode()).isEqualToIgnoringCase("eur");
        assertThat(currencyDTO.getCode()).isEqualTo("EUR");
        assertThat(currencyDTO.getCode()).toString();
        assertThat(currencyDTO.getCode()).hasSize(3);
    }

    @Test
    void nameTest() {
        assertThat(currencyDTO.getName()).asString();
        assertThat(currencyDTO.getName()).isNotEmpty();
        assertThat(currencyDTO.getName()).isNotNull();
        assertThat(currencyDTO.getName()).isEqualToIgnoringCase("Euro");
        assertThat(currencyDTO.getName()).isEqualTo("euro");
        assertThat(currencyDTO.getName()).toString();

    }

}