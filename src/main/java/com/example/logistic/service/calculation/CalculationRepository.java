package com.example.logistic.service.calculation;

import com.example.logistic.entity.Calculation;
import com.example.logistic.service.base.LongJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends LongJpaRepository<Calculation> {
}
