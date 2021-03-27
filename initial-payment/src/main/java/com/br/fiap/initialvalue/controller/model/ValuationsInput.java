package com.br.fiap.initialvalue.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValuationsInput {

    @JsonProperty("escola")
    private Boolean school;

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

}
