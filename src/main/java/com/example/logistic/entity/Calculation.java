package com.example.logistic.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "calculations_history")
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private BigDecimal weight;

    @ManyToOne
    @JoinColumn(name = "from_country_id", referencedColumnName = "id")
    private Country countryFrom;

    @ManyToOne
    @JoinColumn(name = "to_country_id", referencedColumnName = "id")
    private Country countryTo;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "sum_price")
    private BigDecimal sumPrice;
}
