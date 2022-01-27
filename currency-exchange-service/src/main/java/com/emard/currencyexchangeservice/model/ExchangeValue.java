package com.emard.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExchangeValue {
    
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "fromD")
    private String from;
    @Column(name = "toD")
    private String to;
    private BigDecimal conversionMultiple;
    private Integer port;
}
