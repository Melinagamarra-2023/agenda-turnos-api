package com.melina.beauty_salon_booking_backend.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestDto{

    private Long id;

    private String name;

    private String lastname;

    private String dni;

    private String address;

    private String phone;

    private String email;


}
