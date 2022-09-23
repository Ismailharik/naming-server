package com.microservices.currencyexchangeservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyExchange {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CURRENCY_FROM")
    private String from;
    @Column(name="CURRENCY_TO")
    private String to;
    private BigDecimal conversionMultiple;

    private String environment;

    public CurrencyExchange(Long id,String from ,String to ,BigDecimal conversionMultiple ){
        this.id=id;
        this.from=from;
        this.to= to;
        this.conversionMultiple=conversionMultiple;
    }
}
