package com.br.fiap.initialvalue.service;

import com.br.fiap.initialvalue.controller.model.PropertyValueOutput;
import com.br.fiap.initialvalue.util.FormatValue;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CalculateInitialValueService {

    private final FormatValue formatValue;

    public PropertyValueOutput calculateValueWithMeter(Double squareMeter, BigDecimal meterValue) {

        val multiply = meterValue.multiply(BigDecimal.valueOf(squareMeter));

        val result = formatValue.formattedValue(multiply);

        return new PropertyValueOutput(result);

    }

}
