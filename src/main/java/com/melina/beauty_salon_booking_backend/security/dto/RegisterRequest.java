package com.melina.beauty_salon_booking_backend.security.dto;

import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String cuit;
    private String dni;
    private String phone;
    private String address;
    private Set<String> roles;
}
