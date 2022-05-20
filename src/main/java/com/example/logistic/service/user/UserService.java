package com.example.logistic.service.user;

import com.example.logistic.entity.User;
import com.example.logistic.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor

@Service
public class UserService {
    private final UserRepository userRepository;

    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException(String.format("User with email: %s not found", email)));
    }
}
