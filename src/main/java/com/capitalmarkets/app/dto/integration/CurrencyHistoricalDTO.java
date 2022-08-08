package com.capitalmarkets.app.dto.integration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CurrencyHistoricalDTO {

    public double amount;
    public String base;
    public String startDate;
    public String endDate;
    public CurrencyRatesDTO rates;
}
