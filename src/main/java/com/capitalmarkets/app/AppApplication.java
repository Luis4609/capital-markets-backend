package com.capitalmarkets.app;

import com.capitalmarkets.app.data.providers.ICurrencyProvider;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.integration.adapters.ICurrencyAdapter;
import com.capitalmarkets.app.integration.adapters.services.IcurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ICurrencyAdapter adapter, IcurrencyService service, ICurrencyProvider prov) {
        return args -> {


            adapter.getAll();
            adapter.getConversion(10, "GBP", "USD");

            for (CurrencyApiDTO currencyApiDTO : service.getAll()) {

                prov.create(currencyApiDTO);
                log.info(currencyApiDTO.toString());
            }


            CurrencyConverterDTO prueba2 = service.getConversion(10.5, "GBP", "USD");
            log.info(prueba2.toString());

            CurrencyHistoricalDTO prueba3 = service.getHistorical("2022-01-01", 5, "EUR", "GBP");
            log.info(prueba3.toString());
        };

    }
}
