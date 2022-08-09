package com.capitalmarkets.app.data.providers;


import com.capitalmarkets.app.data.daos.ICurrencyDao;
import com.capitalmarkets.app.data.entities.CurrencyModel;
import com.capitalmarkets.app.dto.data.CurrencyDTO;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest()
public class ICurrencyProviderTest {
    @Autowired
    private ICurrencyDao currencyDao;

    @Autowired
    private ICurrencyProvider iCurrencyProvider;
//    @Autowired
//    private CurrencyDTO currencyDTO;


    @Test
    @DisplayName(value = " Test1 -> Para recoger bien la divisa por su nombre.")
    public void getCurrencyByNameTest() {


        CurrencyDTO dto = iCurrencyProvider.getCurrencyByName("euro");


        assertThat(dto).isNotNull();
        //assertThat(dto.getCode()).isNotEmpty();
        assertThat(dto.code).isNotEmpty();
        assertThat(dto.name).isEqualTo("euro");
        //assertThat(dto.getName()).isEqualTo("euro");
        assertThat(dto.name).isEqualToIgnoringCase("euro");
        //assertThat(dto.getName()).isEqualToIgnoringCase("euro");

        //TODO


    }

    @Test
    @DisplayName(value = "Test2 -> Para comprobar que devuelve el nombre de una divisa por el código.")
    public void getCurrencyByCodeTest() {

        CurrencyDTO dto = iCurrencyProvider.getCurrencyByCode("EUR");
        //CurrencyDTO dto=new CurrencyDTO("eur","euro");


        assertThat(dto).isNotNull();
        //assertThat(dto.getCode()).isNotEmpty();
        assertThat(dto.code).isNotEmpty();
        assertThat(dto.code).isEqualTo("EUR");
        //assertThat(dto.getCode()).isEqualTo("EUR");
        assertThat(dto.code).hasSize(3);
        assertThat(dto.code).isEqualToIgnoringCase("eur");
        //assertThat(dto.getCode()).isEqualToIgnoringCase("EUR");
        assertThat(dto.code).asString();
        //assertThat(dto.getCode()).asString();


    }

    @Test
    @DisplayName(value = "Test3 -> Para que devuelva todas las divisas de la bd.")
    public void getAllTest() {
        Collection<CurrencyDTO> currencies = iCurrencyProvider.getAll();
        assertThat(currencies).isNotEmpty();
        assertThat(currencies).isNotNull();

        //ToDo
//        List<CurrencyModel> mockupBD = new ArrayList<>();
//        CurrencyModel currencyModel = new CurrencyModel(1, "EUR", "euro");
//        CurrencyModel currencyModel2 = new CurrencyModel(2, "USD", "dollar");
//        CurrencyModel currencyModel3 = new CurrencyModel(3, "JPN", "yen");
//
//        mockupBD.add(currencyModel);
//        mockupBD.add(currencyModel2);
//        mockupBD.add(currencyModel3);
//
//        for (CurrencyModel cm: mockupBD  ) {
//            cm.
//
//        }

    }

    @Test
    @DisplayName(value = "Test4 -> Comprobar la construcción del currencyModel a partir del dto de la api y guarda la divisa en la BD.")
    public void createTest() {

        CurrencyApiDTO currencyApiDTO = new CurrencyApiDTO("ABC", "abc");

        CurrencyModel cM = CurrencyModel.builder().code(currencyApiDTO.code).name(currencyApiDTO.name).build();

        currencyDao.save(cM);

        Collection<CurrencyDTO> currencies = iCurrencyProvider.getAll();
    }


}
