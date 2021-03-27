package com.br.fiap.initialvalue.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class PropertyInformation {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean school;

    private Boolean hospital;

    private Boolean pharmacy;

    private Boolean marketplace;

    private Boolean shoppingCenter;

    private Boolean subway;

    private String district;

    private BigDecimal additionalValue = BigDecimal.ZERO;

}
