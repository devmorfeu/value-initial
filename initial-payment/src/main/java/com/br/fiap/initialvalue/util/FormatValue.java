package com.br.fiap.initialvalue.util;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

@RequiredArgsConstructor
@Component
public class FormatValue {

    private static final Locale localeBR = new Locale("pt","BR");

    public String formattedValue(BigDecimal value) {

        val currencyInstance = DecimalFormat.getCurrencyInstance(localeBR);

        return currencyInstance.format(value);

    }
}
