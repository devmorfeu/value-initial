package com.br.fiap.initialvalue.service;

import com.br.fiap.initialvalue.controller.model.ValuationsInput;
import com.br.fiap.initialvalue.controller.model.ValuationsOutput;
import com.br.fiap.initialvalue.entities.PropertyInformation;
import com.br.fiap.initialvalue.repository.PropertyInformationRepo;
import com.br.fiap.initialvalue.util.FormatValue;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SaveInfosAndCalculateValue {

    private final PropertyInformationRepo repository;

    private static final BigDecimal VALUE_ADD = new BigDecimal("10000");

    private final FormatValue formatValue;

    public ValuationsOutput saveInfos(ValuationsInput valuationsInput) {

        ModelMapper modelMapper = new ModelMapper();

        val prop = modelMapper.map(valuationsInput, PropertyInformation.class);

        calculateValue(valuationsInput, prop);

        val save = repository.save(prop);

        String additionalValueFormat = formatValue.formattedValue(prop.getAdditionalValue());

        return new ValuationsOutput(prop.getId(), additionalValueFormat);
    }

    private void calculateValue(ValuationsInput valuationsInput, PropertyInformation prop){

        if (valuationsInput.getHospital()){ prop.setAdditionalValue(prop.getAdditionalValue().add(VALUE_ADD)); }
        if (valuationsInput.getSubway()){ prop.setAdditionalValue(prop.getAdditionalValue().add(VALUE_ADD)); }
        if (valuationsInput.getMarketplace()){ prop.setAdditionalValue(prop.getAdditionalValue().add(new BigDecimal("10000"))); }
        if (valuationsInput.getPharmacy()){ prop.setAdditionalValue(prop.getAdditionalValue().add(new BigDecimal("10000"))); }
        if (valuationsInput.getShoppingCenter()){ prop.setAdditionalValue(prop.getAdditionalValue().add(new BigDecimal("10000"))); }
        if (valuationsInput.getSchool()){ prop.setAdditionalValue(prop.getAdditionalValue().add(new BigDecimal("10000"))); }

    }
}
