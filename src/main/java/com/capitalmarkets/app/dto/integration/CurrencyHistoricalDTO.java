package com.capitalmarkets.app.dto.integration;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class CurrencyHistoricalDTO {

    private double amount;
    private String base;
    private String conversion;
    private String startDate;
    private String endDate;
    private List<CurrencyRatesDTO> rates;

}
