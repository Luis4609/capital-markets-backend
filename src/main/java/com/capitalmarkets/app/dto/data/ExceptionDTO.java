package com.capitalmarkets.app.dto.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class ExceptionDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String exception;

}
