package com.emard.currencyexchangeservice;

import java.math.BigDecimal;

import com.emard.currencyexchangeservice.model.ExchangeValue;
import com.emard.currencyexchangeservice.repo.ExchangeValueRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ExchangeValueRepository repo){
		return args -> {
			ExchangeValue e1 = new ExchangeValue(null, "USD", "INR", BigDecimal.valueOf(70), 0);
			ExchangeValue e2 = new ExchangeValue(null, "EUR", "INR", BigDecimal.valueOf(112), 0);
			ExchangeValue e3 = new ExchangeValue(null, "AUD", "INR", BigDecimal.valueOf(25), 0);
			repo.save(e1);
			repo.save(e2);
			repo.save(e3);

			repo.findAll().forEach(c -> {
				log.info("ExchanValue [{}]", c);
			});
		};
	}

}
