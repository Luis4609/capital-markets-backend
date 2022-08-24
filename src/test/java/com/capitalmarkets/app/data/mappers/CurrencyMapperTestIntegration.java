package com.capitalmarkets.app.data.mappers;


import com.capitalmarkets.app.data.entities.CurrencyModel;
import com.capitalmarkets.app.dto.data.CurrencyDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CurrencyMapper.class)
public class CurrencyMapperTestIntegration {

    @Autowired
    private CurrencyMapper currencyMapper;

    @Test
    @DisplayName(value = "Test1 -> Test para comprobar el mappeo a DTO de las CurrencyModel")
    public void MapperCurrencyToDTOTest() {
        CurrencyModel currencyModel = new CurrencyModel(1, "EUR", "Euro");
        CurrencyDTO dto = currencyMapper.mapToDto(currencyModel);
        assertThat(dto).isNotNull();
        assertThat(dto.getCode()).isNotNull();
        assertThat(dto.getCode()).isNotEmpty();
        assertThat(dto.getCode()).isEqualTo("EUR");
        assertThat(dto.getCode()).isEqualToIgnoringCase("eur");
        assertThat(dto.getCode()).hasSize(3);
        assertThat(dto.getName()).isNotNull();
        assertThat(dto.getName()).isNotEmpty();
        assertThat(dto.getName()).isEqualTo("Euro");
        assertThat(dto.getName()).isEqualToIgnoringCase("euro");
        assertThat(dto.getName()).isEqualTo("Euro");


    }

    @Test
    @DisplayName(value = "Test2 -> Comprobar que el DTO transforma a Entity")
    public void MapperToEntityTest() {
        CurrencyDTO currencyDTO = new CurrencyDTO("EUR", "Euro");
        CurrencyModel currencyModel = currencyMapper.mapToEntity(currencyDTO);

        assertThat(currencyModel).isNotNull();
        assertThat(currencyModel.getName()).isNotNull();
        assertThat(currencyModel.getName()).isNotEmpty();
        assertThat(currencyModel.getName()).isEqualTo("Euro");
        assertThat(currencyModel.getName()).isEqualToIgnoringCase("EURO");
        assertThat(currencyModel.getCode()).isNotNull();
        assertThat(currencyModel.getCode()).isNotEmpty();
        assertThat(currencyModel.getCode()).isEqualTo("EUR");
        assertThat(currencyModel.getCode()).isEqualToIgnoringCase("eur");
        assertThat(currencyModel.getCode()).hasSize(3);

    }

}
