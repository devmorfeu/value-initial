package com.br.fiap.initialvalue.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValuationsOutput {

    private Long id;

    @JsonProperty("valor_adicional")
    private String additionalValue;
}
