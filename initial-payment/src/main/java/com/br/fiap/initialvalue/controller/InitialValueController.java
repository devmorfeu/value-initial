package com.br.fiap.initialvalue.controller;

import com.br.fiap.initialvalue.controller.model.PropertyValueOutput;
import com.br.fiap.initialvalue.controller.model.ValuationsInput;
import com.br.fiap.initialvalue.controller.model.ValuationsOutput;
import com.br.fiap.initialvalue.controller.model.ValuationsOutputById;
import com.br.fiap.initialvalue.entities.PropertyInformation;
import com.br.fiap.initialvalue.repository.PropertyInformationRepo;
import com.br.fiap.initialvalue.service.CalculateInitialValueService;
import com.br.fiap.initialvalue.service.SaveInfosAndCalculateValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pagamentos/v1")
public class InitialValueController {

    private final CalculateInitialValueService service;

    private final SaveInfosAndCalculateValue serviceValuations;

    private final PropertyInformationRepo repo;

    Logger logger = LoggerFactory.getLogger(InitialValueController.class);


    @GetMapping("/valores_imoveis")
    public ResponseEntity<PropertyValueOutput> initialPayment(@RequestParam("metro_quadrado") @Valid Double squareMeter,
                                                              @RequestParam("valor_metro") @Valid BigDecimal meterValue) {

        logger.info("Inicio do processo | valor_metro: {} metro_quadrado: {}", squareMeter, meterValue);

        val result = service.calculateValueWithMeter(squareMeter, meterValue);

        logger.info("Fim do processo | resultado : {}", result.getValueResponse());

        return status(OK).body(result);
    }

    @PostMapping("/valorizacoes")
    public ResponseEntity<ValuationsOutput> valuations(@RequestBody @Valid ValuationsInput valuationsInput){

        logger.info("Inicio do processo | Payload: {}", valuationsInput);

        val valuationsOutput = serviceValuations.saveInfos(valuationsInput);

        return status(CREATED).body(valuationsOutput);

    }

    @GetMapping("/valorizacoes")
    public ResponseEntity<ValuationsOutputById> valuationsById(@RequestParam("id") Long id){

        ModelMapper modelMapper = new ModelMapper();

        val propertyInformation = repo.findById(id).orElseThrow(RuntimeException::new);

        val response = modelMapper.map(propertyInformation, ValuationsOutputById.class);

        return status(OK).body(response);
    }
}
