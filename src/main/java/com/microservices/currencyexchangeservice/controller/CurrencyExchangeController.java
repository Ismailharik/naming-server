package com.microservices.currencyexchangeservice.controller;

import com.microservices.currencyexchangeservice.entities.CurrencyExchange;
import com.microservices.currencyexchangeservice.entities.CurrencyExchange;
import com.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;
import java.math.BigDecimal;
@RestController
@AllArgsConstructor
public class CurrencyExchangeController {
    private Environment environment;
    private CurrencyExchangeRepository currencyExchangeRepository;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveEchangeValue(@PathVariable(name = "from") String from, @PathVariable String to ){

        CurrencyExchange currencyEchange= currencyExchangeRepository.findByFromAndTo(from,to);

        String port =environment.getProperty("local.server.port");
        System.out.println(port);
        currencyEchange.setEnvironment(port);
        if(currencyEchange==null){
            throw new RuntimeException("Unable to find data for"+from+" to "+ to);
        }
        return currencyEchange ;
    }

}
