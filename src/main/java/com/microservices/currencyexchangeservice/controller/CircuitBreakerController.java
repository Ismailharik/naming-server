package com.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CircuitBreakerController {
    private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name="sample-api",fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name="default",fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default") //   @Bulkhead(name = "sample-api")
    //10s =>1000 calls to the sample api
        public String sampleApi(){
        logger.info("Sample api call received");

      /*  ResponseEntity<String> forEntity = new RestTemplate()
                //we know the url isn't working
               .getForEntity("http://localhost:8080/some-dummy-urk",String.class);
        return forEntity.getBody();

       */
        return "sample API";
        }
        public String hardcodedResponse(Exception ex){
            return "fallback-response";
        }

        public String hardCodedResponse(){
        return "fallback-response";
        }
}