package com.capitalmarkets.app.data.mappers;

import com.capitalmarkets.app.data.entities.CurrencyModel;
import com.capitalmarkets.app.dto.data.CurrencyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurrencyMapperTest {

    @Mock
    private CurrencyDTO currencyDTO;
    @Mock
    private CurrencyModel currencyModel;
    @InjectMocks
    private CurrencyMapper currencyMapper;

    @BeforeEach
    void setup() {

        MockitoAnnotations.openMocks(this);
        currencyDTO = new CurrencyDTO("EUR", "euro");
        currencyModel = new CurrencyModel(0, "EUR", "euro");


    }

    @Test
    void mapToDto() {

        CurrencyDTO result = currencyMapper.mapToDto(currencyModel);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(currencyDTO, result);
        Assertions.assertEquals(currencyDTO.getCode(), result.getCode());
        Assertions.assertEquals(currencyDTO.getName(), result.getName());


    }

    @Test
    void mapToEntity() {

        CurrencyModel result = currencyMapper.mapToEntity(currencyDTO);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(currencyModel, result);
        Assertions.assertEquals(currencyModel.getCode(), result.getCode());
        Assertions.assertEquals(currencyModel.getName(), result.getName());
    }
}