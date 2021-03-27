package com.br.fiap.initialvalue.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseErrorData {

    @JsonProperty("mensagem")
    private String message;
}
