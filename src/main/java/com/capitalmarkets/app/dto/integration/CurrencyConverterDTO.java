package com.capitalmarkets.app.dto.integration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyConverterDTO {

    public double amount;
    public String from;
    public String to;
    public double value;
}
