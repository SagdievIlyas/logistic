package com.example.logistic.controller;


import com.example.logistic.dto.CreateCalculationRequest;
import com.example.logistic.entity.User;
import com.example.logistic.service.calculation.CalculationService;
import com.example.logistic.service.user.UserRepository;
import com.example.logistic.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor

@RestController
@RequestMapping("api/v1/calculation")

public class CalculationController {

    private final CalculationService calculationService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createCalculation(@RequestBody CreateCalculationRequest request) {
        User admin =  userService.getByEmail("admin");
        return ResponseEntity.ok(calculationService.createCalculation(request, admin));
    }
}
