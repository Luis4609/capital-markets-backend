package com.capitalmarkets.app.data.mappers;


import com.capitalmarkets.app.data.entities.CurrencyModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CurrencyMapper.class)
public class CurrencyMapperTest {

    @Autowired
    private CurrencyMapper currencyMapper;


    @Test
    @DisplayName(value = "Test2 -> Test para comprobar el mappeo a DTO de las CurrencyModel")
    public void MapperCurrencyToDTOTest(){
        List<CurrencyModel> listModel = new ArrayList<CurrencyModel>();
        listModel.add(new CurrencyModel( 1, "EUR", "euro"));
        listModel.add(new CurrencyModel( 2, "USD", "dollar"));
        listModel.add(new CurrencyModel( 3, "JPY", "yen"));





    }
}
