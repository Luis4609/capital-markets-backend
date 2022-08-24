package com.capitalmarkets.app.dto.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class CurrencyConverterDTOTestIntegration {

    private CurrencyConverterDTO currencyConverterDTO = new CurrencyConverterDTO(10.5, "GBP", "USD", 12.3584);

    @Test
    void amountTest(){
        assertThat(currencyConverterDTO.getAmount()).isNotNull();
        assertThat(currencyConverterDTO.getAmount()).isNotNegative();
        assertThat(currencyConverterDTO.getAmount()).isNotNaN();
        assertThat(currencyConverterDTO.getAmount()).isNotInfinite();
        assertThat(currencyConverterDTO.getAmount()).isGreaterThanOrEqualTo(0);
        assertThat(currencyConverterDTO.getAmount()).isEqualTo(10.5);
        assertThat(currencyConverterDTO.getAmount()).toString();
    }
    @Test
    void fromTest(){
        assertThat(currencyConverterDTO.getFrom()).asString();
        assertThat(currencyConverterDTO.getFrom()).isNotEmpty();
        assertThat(currencyConverterDTO.getFrom()).isNotNull();
        assertThat(currencyConverterDTO.getFrom()).isEqualToIgnoringCase("gbp");
        assertThat(currencyConverterDTO.getFrom()).isEqualTo("GBP");
        assertThat(currencyConverterDTO.getFrom()).toString();
        assertThat(currencyConverterDTO.getFrom()).hasSize(3);
    }

    @Test
    void toTest(){
        assertThat(currencyConverterDTO.getTo()).asString();
        assertThat(currencyConverterDTO.getTo()).isNotEmpty();
        assertThat(currencyConverterDTO.getTo()).isNotNull();
        assertThat(currencyConverterDTO.getTo()).isEqualToIgnoringCase("USd");
        assertThat(currencyConverterDTO.getTo()).isEqualTo("USD");
        assertThat(currencyConverterDTO.getTo()).toString();
        assertThat(currencyConverterDTO.getTo()).hasSize(3);
    }

    @Test
    void valueTest(){
        assertThat(currencyConverterDTO.getValue()).isNotNull();
        assertThat(currencyConverterDTO.getValue()).isNotNegative();
        assertThat(currencyConverterDTO.getValue()).isNotNaN();
        assertThat(currencyConverterDTO.getValue()).isNotInfinite();
        assertThat(currencyConverterDTO.getValue()).isGreaterThanOrEqualTo(0);
        assertThat(currencyConverterDTO.getValue()).isEqualTo(12.3584);
        assertThat(currencyConverterDTO.getValue()).toString();
    }
}