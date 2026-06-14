package com.melina.beauty_salon_booking_backend.security.controller;

import com.melina.beauty_salon_booking_backend.security.dto.AuthResponse;
import com.melina.beauty_salon_booking_backend.security.dto.LoginRequest;
import com.melina.beauty_salon_booking_backend.security.dto.RegisterRequest;
import com.melina.beauty_salon_booking_backend.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        service.register(registerRequest);
        return ResponseEntity.ok(Map.of("message", "User registered successfully!"));
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(service.login(loginRequest));
    }
}
