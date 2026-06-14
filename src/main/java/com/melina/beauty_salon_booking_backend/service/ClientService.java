package com.melina.beauty_salon_booking_backend.service;

import com.melina.beauty_salon_booking_backend.dto.ClientRequestDto;
import com.melina.beauty_salon_booking_backend.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {

    ClientResponseDto createClient(ClientRequestDto request);
    ClientResponseDto getClientByCuit(String cuit);
    List<ClientResponseDto> getAllClients();
    ClientResponseDto updateClient(String cuit, ClientRequestDto request);
    void deleteClient(String cuit);
    ClientResponseDto getClientByDni(String dni);
    ClientResponseDto getClientByEmail(String email);
    ClientResponseDto enableClient(Long id);
    ClientResponseDto disableClient(Long id);
}
