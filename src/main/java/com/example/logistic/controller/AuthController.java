package com.example.logistic.controller;
import com.example.logistic.config.security.jwt.JwtUtils;
import com.example.logistic.dto.auth.AuthenticationRequest;
import com.example.logistic.dto.auth.AuthenticationResponse;
import com.example.logistic.entity.User;
import com.example.logistic.service.user.UserService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticationRequest request) {

        User user = userService.getByEmail(request.getEmail());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication (authentication);

        String token = jwtUtils.generateJwtToken (authentication);
        Claims claims = jwtUtils.getTokenInfo (token);

        return ResponseEntity.ok(new AuthenticationResponse(
                user.getEmail(),
                token));
    }
}
