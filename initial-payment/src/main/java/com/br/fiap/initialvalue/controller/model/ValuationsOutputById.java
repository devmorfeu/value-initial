package com.br.fiap.initialvalue.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ValuationsOutputById {

    private Long id;

    @JsonProperty("escola")
    private Boolean school;

    @JsonProperty("hospital")
    private Boolean hospital;

    @JsonProperty("farmacia")
    private Boolean pharmacy;

    @JsonProperty("mercado")
    private Boolean marketplace;

    @JsonProperty("shopping_center")
    private Boolean shoppingCenter;

    @JsonProperty("metro")
    private Boolean subway;

    @JsonProperty("bairro")
    private String district;

    @JsonProperty("valor_adicional")
    private BigDecimal additionalValue;
}
