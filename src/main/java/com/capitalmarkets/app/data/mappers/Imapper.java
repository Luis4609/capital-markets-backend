package com.capitalmarkets.app.data.mappers;

public interface Imapper <T,R>{

    R mapToDto(T t);

    T mapToEntity(R r);


}
