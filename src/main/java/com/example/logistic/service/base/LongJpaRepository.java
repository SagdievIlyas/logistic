package com.example.logistic.service.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LongJpaRepository<T> extends JpaRepository<T, Long> {
}
