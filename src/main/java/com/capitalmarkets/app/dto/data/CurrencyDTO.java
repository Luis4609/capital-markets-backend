package com.capitalmarkets.app.dto.data;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class CurrencyDTO extends ExceptionDTO {

    private String code;
    private String name;

    public CurrencyDTO(String exception){
        super(exception);
    }


}
