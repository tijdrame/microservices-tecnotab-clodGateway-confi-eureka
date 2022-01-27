package com.emard.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.emard.currencyconversionservice.facade.CurrencyExchangeProxy;
import com.emard.currencyconversionservice.model.CalculatedAmount;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@AllArgsConstructor
@Log4j2
public class CurrencyConversionController {

    private final RestTemplate restTemplate;
    private final CurrencyExchangeProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CalculatedAmount calculateAmount(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        log.info("message [{}]", quantity);
        CalculatedAmount c = proxy.retrieveExchange(from, to);

        c.setQuantity(quantity);
        c.setTotalCalulatedAmount(quantity.multiply(c.getConversionMultiple()));
            //CalculatedAmount c = new CalculatedAmount(100l, from, to, BigDecimal.ONE, quantity, BigDecimal.TEN, 8100);
        return c;
    }

    /*@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CalculatedAmount calculateAmount(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CalculatedAmount> resp = restTemplate.getForEntity(
            "http://localhost:8001/currency-exchange/from/{from}/to/{to}", 
            CalculatedAmount.class, 
            uriVariables);
        CalculatedAmount c = resp.getBody();
        c.setQuantity(quantity);
        c.setTotalCalulatedAmount(quantity.multiply(c.getConversionMultiple()));
            //CalculatedAmount c = new CalculatedAmount(100l, from, to, BigDecimal.ONE, quantity, BigDecimal.TEN, 8100);
        return c;
    }*/
    
}
