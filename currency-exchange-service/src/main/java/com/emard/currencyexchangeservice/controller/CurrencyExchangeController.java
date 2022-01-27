package com.emard.currencyexchangeservice.controller;

import java.math.BigDecimal;

import com.emard.currencyexchangeservice.model.ExchangeValue;
import com.emard.currencyexchangeservice.repo.ExchangeValueRepository;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {
    
    private final Environment environment;
    private final ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchange(@PathVariable String from, @PathVariable String to) {
        ExchangeValue e = repository.findByFromAndTo(from, to);
        if(e != null ) e.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return e;
        //return new ExchangeValue(1000l, "USD", "INR", BigDecimal.valueOf(70), Integer.parseInt(environment.getProperty("local.server.port")));
    }
}
