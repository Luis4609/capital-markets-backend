package com.capitalmarkets.app.dto.integration;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class CurrencyRatesDTO {

    private String date;
    private double result;


}
