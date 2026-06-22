package com.melina.beauty_salon_booking_backend.dto;

import com.melina.beauty_salon_booking_backend.model.Service;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfessionalRequestDto {

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
