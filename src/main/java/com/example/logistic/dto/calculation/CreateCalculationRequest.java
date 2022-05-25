package com.example.logistic.dto.calculation;

import com.example.logistic.entity.Country;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class CreateCalculationRequest {

    private BigDecimal weight;

    private Country countryFrom;

    private Country countryTo;
}
