package com.capitalmarkets.app.dto.integration;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class CurrencyHistoricalDTO implements Serializable {

    private double amount;
    private String base;
    private String to;
    private String conversion;
    private String startDate;
    private String endDate;
    private List<CurrencyRatesDTO> rates;

}
