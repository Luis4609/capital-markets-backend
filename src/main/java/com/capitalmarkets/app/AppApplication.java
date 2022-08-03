package com.capitalmarkets.app;

import com.capitalmarkets.app.data.daos.ICurrencyDao;
import com.capitalmarkets.app.data.entities.CurrencyModel;
import com.capitalmarkets.app.data.providers.ICurrencyProvider;
import com.capitalmarkets.app.implementation.service.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ICurrencyDao currencyDao, IApiService iApiService) {
        return args -> {

            //Insert initial Currencies from external API
            for (Map.Entry<String, String> entry : iApiService.getCurrenciesJson().entrySet()) {

                CurrencyModel currencyModel = new CurrencyModel(entry.getKey(), entry.getValue());
                currencyDao.save(currencyModel);

            }
        };
    }
}
