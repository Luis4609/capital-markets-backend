package com.capitalmarkets.app.data.providers;


import com.capitalmarkets.app.dto.data.CurrencyDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


//@SpringBootTest()
public class ICurrencyProviderTestIntegration {
//    @Autowired
    private ICurrencyProvider iCurrencyProvider;


//    @Test
    @DisplayName(value = " Test1 -> Para recoger bien la divisa por su nombre.")
    public void getCurrencyByNameTest() {
        CurrencyDTO dto = iCurrencyProvider.getCurrencyByName("Euro");
        assertThat(dto).isNotNull();
        assertThat(dto.getCode()).isNotEmpty();
        assertThat(dto.getName()).isEqualTo("Euro");
        assertThat(dto.getName()).isEqualToIgnoringCase("euro");
    }

//    @Test
    @DisplayName(value = "Test2 -> Para comprobar que devuelve el nombre de una divisa por el código.")
    public void getCurrencyByCodeTest() {
        CurrencyDTO dto = iCurrencyProvider.getCurrencyByCode("EUR");
        assertThat(dto).isNotNull();
        assertThat(dto.getCode()).isNotEmpty();
        assertThat(dto.getCode()).isEqualTo("EUR");
        assertThat(dto.getCode()).hasSize(3);
        assertThat(dto.getCode()).isEqualToIgnoringCase("EUR");
        assertThat(dto.getCode()).asString();


    }

//    @Test
//    @DisplayName(value = "Test3 -> Para que devuelva todas las divisas de la bd.")
//    public void getAllTest() {
//        Collection<CurrencyDTO> currencies = iCurrencyProvider.getAll();
//        assertThat(currencies).isNotEmpty();
//        assertThat(currencies).isNotNull();


//

    //   }

//    @Test
    @DisplayName(value = "Test4 -> Comprobar la construcción del currencyModel a partir del dto de la api y guarda la divisa en la BD.")
    public void createTest() {

        // TODO


    }


}
