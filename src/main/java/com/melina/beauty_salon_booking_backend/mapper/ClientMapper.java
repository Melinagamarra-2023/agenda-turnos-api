package com.melina.beauty_salon_booking_backend.mapper;

import com.melina.beauty_salon_booking_backend.dto.ClientRequestDto;
import com.melina.beauty_salon_booking_backend.dto.ClientResponseDto;
import com.melina.beauty_salon_booking_backend.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientResponseDto toDto(Client entity) {
        return ClientResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .dni(entity.getDni())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .activo(entity.getActivo())
                .build();
    }

    public Client toEntity(ClientRequestDto dto) {
        return Client.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .dni(dto.getDni())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .build();
    }
}
