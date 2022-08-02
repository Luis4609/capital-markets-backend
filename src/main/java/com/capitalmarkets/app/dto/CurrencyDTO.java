package com.capitalmarkets.app.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyDTO {

    public String code;
    public String name;

    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
