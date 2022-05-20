package com.example.logistic.service.rate;

import com.example.logistic.entity.Rate;
import com.example.logistic.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor

@Service
public class RateService {

    private final RateRepository repository;

    public Rate getRate(BigDecimal weight) {
        return repository.getRateByWeight(weight)
                .orElseThrow(() -> new BadRequestException(String.format("Rate not found for weight: %f", weight)));
    }
}
