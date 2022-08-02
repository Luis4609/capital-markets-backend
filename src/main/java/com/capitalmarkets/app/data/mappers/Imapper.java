package com.capitalmarkets.app.data.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Imapper <T,R>{

    R mapToDto(T t);

    T mapToEntity(R r);

    default List<R> mapListToDtoList(Collection<T> list) {
        return list.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    default List<T> mapListToEntityList(Collection<R> list) {
        return list.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
