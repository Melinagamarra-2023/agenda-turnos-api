package com.melina.beauty_salon_booking_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponseDto {

    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private String address;
    private String phone;
    private String email;
    private Boolean activo;

}
