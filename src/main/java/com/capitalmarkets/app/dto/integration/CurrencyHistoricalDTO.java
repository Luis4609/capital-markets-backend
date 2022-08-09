package com.capitalmarkets.app.dto.integration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CurrencyHistoricalDTO {

    private double amount;
    private String base;
    private String conversion;
    private String startDate;
    private String endDate;
    private List<CurrencyRatesDTO> rates;

}
