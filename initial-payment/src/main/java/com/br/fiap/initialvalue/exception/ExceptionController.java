package com.br.fiap.initialvalue.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ExceptionController {

    private static final String INTERNAL_SERVER_ERROR_MESSAGE  = "ERRO INESPERADO, TENTE NOVAMENTE";

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseErrorData> exception(RuntimeException ex) {

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ResponseErrorData(INTERNAL_SERVER_ERROR_MESSAGE));

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseErrorData> exception(MissingServletRequestParameterException ex) {

        return ResponseEntity.status(BAD_REQUEST).body(new ResponseErrorData(requireNonNull(ex.getMessage()).toUpperCase()));

    }
}