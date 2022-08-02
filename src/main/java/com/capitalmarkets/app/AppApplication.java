package com.capitalmarkets.app;

import com.capitalmarkets.app.data.providers.ICurrencyProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ICurrencyProvider cuprovide){
		return args -> {

			cuprovide.getCurrencyByCode("???");
		};
	}
}
