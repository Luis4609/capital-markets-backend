package com.capitalmarkets.app.dto.integration;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CurrencyConverterDTO {

    private double amount;
    private String from;
    private String to;
    private double value;
}
