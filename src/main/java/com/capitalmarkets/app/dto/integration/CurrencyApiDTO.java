package com.capitalmarkets.app.dto.integration;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class CurrencyApiDTO {

    private String code;
    private String name;
}
