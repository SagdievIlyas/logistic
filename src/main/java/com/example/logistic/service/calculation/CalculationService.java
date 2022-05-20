package com.example.logistic.service.calculation;

import com.example.logistic.dto.CreateCalculationRequest;
import com.example.logistic.entity.Calculation;
import com.example.logistic.entity.Rate;
import com.example.logistic.entity.User;
import com.example.logistic.service.rate.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;
    private final RateService rateService;

    @Transactional
    public Calculation createCalculation(CreateCalculationRequest request, User user) {
        Rate rate = rateService.getRate(request.getWeight());

        BigDecimal sum = rate.getRate().multiply(request.getWeight());

        Calculation newCalculation = Calculation.builder()
                .user(user)
                .weight(request.getWeight())
                .countryFrom(request.getCountryFrom())
                .countryTo(request.getCountryTo())
                .dateTime(LocalDateTime.now())
                .sumPrice(sum)
                .build();

        return calculationRepository.save(newCalculation);
    }
}
