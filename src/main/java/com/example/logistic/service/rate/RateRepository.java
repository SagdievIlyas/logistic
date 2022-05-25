package com.example.logistic.service.rate;

import com.example.logistic.entity.Rate;
import com.example.logistic.service.base.LongJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface RateRepository extends LongJpaRepository<Rate> {

    @Query(nativeQuery = true,
            value = "select * " +
                    "from rate r " +
                    "where r.max_weight >= :weight " +
                    "and r.min_weight < :weight " +
                    "and r.start_date <= current_timestamp " +
                    "and r.end_date >= current_timestamp "

    )
    Optional<Rate> getRateByWeight (BigDecimal weight);
}
