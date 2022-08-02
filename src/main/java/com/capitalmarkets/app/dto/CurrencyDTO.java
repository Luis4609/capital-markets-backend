package com.capitalmarkets.app.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyDTO extends ExceptionDTO{

    public String code;
    public String name;

    public CurrencyDTO(String exception){
        super(exception);
    }
    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
