package com.capitalmarkets.app.dto.integration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CurrencyApiDTO {

    public String code;
    public String name;
}
