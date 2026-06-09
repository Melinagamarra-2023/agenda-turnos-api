package com.melina.beauty_salon_booking_backend.service;

import com.melina.beauty_salon_booking_backend.dto.ClientRequestDto;
import com.melina.beauty_salon_booking_backend.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {

    ClientResponseDto createClient(ClientRequestDto request);
    ClientResponseDto getClientById(Long id);
    List<ClientResponseDto> getAllClients();
    ClientResponseDto updateClient(Long id, ClientRequestDto request);
    void deleteClient(Long id);
    ClientResponseDto getClientByDni(String dni);
    ClientResponseDto getClientByEmail(String email);
    ClientResponseDto enableClient(Long id);
    ClientResponseDto disableClient(Long id);
}
