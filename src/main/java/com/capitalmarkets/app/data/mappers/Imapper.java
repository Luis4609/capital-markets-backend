package com.capitalmarkets.app.data.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Imapper <T,R>{

    R mapToDto(T t);

    T mapToEntity(R r);


}
