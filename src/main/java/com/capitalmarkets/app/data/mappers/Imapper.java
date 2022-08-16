package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.UserModel;
import com.capitalmarkets.app.dto.data.UserWithOutPassDTO;

public interface Imapper <T,R>{

    R mapToDto(T t);



    T mapToEntity(R r);





}
