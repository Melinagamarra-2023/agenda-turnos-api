package com.melina.beauty_salon_booking_backend.mapper;


import com.melina.beauty_salon_booking_backend.dto.ClientResponseDto;
import com.melina.beauty_salon_booking_backend.dto.ProfessionalRequestDto;
import com.melina.beauty_salon_booking_backend.dto.ProfessionalResponseDto;
import com.melina.beauty_salon_booking_backend.model.Professional;
import org.springframework.stereotype.Component;

@Component
public class ProfessionalMapper {

    public ProfessionalResponseDto toDto(Professional entity) {
        return ProfessionalResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .dni(entity.getDni())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .cuit(entity.getCuit())
                .activo(entity.getActivo())
                .build();
    }

    public Professional toEntity(ProfessionalRequestDto dto) {
        return Professional.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .dni(dto.getDni())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .cuit(dto.getCuit())
                .activo(dto.getActivo() == null ? Boolean.TRUE : dto.getActivo())
                .build();
    }
}
