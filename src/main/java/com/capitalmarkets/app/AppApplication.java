package com.capitalmarkets.app;

import com.capitalmarkets.app.core.services.EmailService;
import com.capitalmarkets.app.core.services.UserControllerService;
import com.capitalmarkets.app.data.providers.ICurrencyProvider;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
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
    public CommandLineRunner runner(IcurrencyService service, ICurrencyProvider prov, UserControllerService prueba1) {
        return args -> {

            prueba1.restartPassword();

            for (CurrencyApiDTO currencyApiDTO : service.getAll()) {

                prov.create(currencyApiDTO);
                log.info(currencyApiDTO.toString());
            }


            CurrencyConverterDTO prueba2 = service.getConversion(10.5, "GBP", "USD");

            log.info( prueba2.toString());

            CurrencyHistoricalDTO prueba3 = service.getHistorical("2022-08-23", 5, "EUR", "GBP");
            log.info(prueba3.toString());

            CurrencyHistoricalDTO prueba4=service.getInterval("2022-08-23","2022-08-24",30,"USD","GBP");
           log.info(prueba4.toString());

        };


    }
}

