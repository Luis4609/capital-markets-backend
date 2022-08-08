package com.capitalmarkets.app.data.mappers;


import com.capitalmarkets.app.data.entities.CurrencyModel;
import com.capitalmarkets.app.dto.data.CurrencyDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

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

        CurrencyModel currencyModel = new CurrencyModel(1, "EUR", "euro");

        CurrencyDTO dto = new CurrencyDTO(currencyModel.getCode(), currencyModel.getName());
        assertThat(dto).isNotNull();
        assertThat(dto).isEqualTo(new CurrencyDTO( "EUR", "euro"));

    }

    @Test
    @DisplayName(value= "Test3 -> Comprobar que el DTO transforma a Entity")
    public void MapperToEntityTest(){
        CurrencyDTO currencyDTO = new CurrencyDTO( "EUR", "euro");
        CurrencyModel currencyModel =new CurrencyModel(0, currencyDTO.code, currencyDTO.name );

        assertThat(currencyModel).isNotNull();
        assertThat(currencyModel.getName()).isNotEmpty();
        assertThat(currencyModel.getCode()).isNotEmpty();
        assertThat(currencyModel.getCode()).isEqualTo("EUR");
        assertThat(currencyModel.getName()).isEqualTo("euro");
        assertThat(currencyModel).isEqualTo(new CurrencyModel( 0, "EUR", "euro"));
    }

}
