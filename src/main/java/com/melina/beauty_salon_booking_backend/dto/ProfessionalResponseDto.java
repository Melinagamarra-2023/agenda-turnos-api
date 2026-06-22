package com.melina.beauty_salon_booking_backend.dto;


import com.melina.beauty_salon_booking_backend.model.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessionalResponseDto {
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private String address;
    private String phone;
    private String email;
    private String cuit;
    private List<Service> services;
    private Boolean activo;

}
