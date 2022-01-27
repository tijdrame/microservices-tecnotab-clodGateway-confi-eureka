package com.emard.currencyconversionservice.facade;

import com.emard.currencyconversionservice.model.CalculatedAmount;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")//, url = "http://currency-exchange-service/")
public interface CurrencyExchangeProxy {
    
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CalculatedAmount retrieveExchange(@PathVariable String from, @PathVariable String to);
}
