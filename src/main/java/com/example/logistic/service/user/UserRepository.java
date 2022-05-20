package com.example.logistic.service.user;

import com.example.logistic.entity.User;
import com.example.logistic.service.base.LongJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends LongJpaRepository<User> {

    Optional<User> findByEmail(String email);
}
