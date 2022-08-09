package com.capitalmarkets.app.implementation.mappers;

import java.util.List;


public interface Imapper<R> {

    R mapToDto(String s);


    List<R> mapListToDtoList(String s);



}
