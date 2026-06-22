package com.melina.beauty_salon_booking_backend.service;



import com.melina.beauty_salon_booking_backend.dto.ProfessionalRequestDto;
import com.melina.beauty_salon_booking_backend.dto.ProfessionalResponseDto;

import java.util.List;

public interface ProfessionalService {
    ProfessionalResponseDto createProfessional(ProfessionalRequestDto request);
    ProfessionalResponseDto getPrefessionalByCuit(String cuit);
    List<ProfessionalResponseDto> getAllProfessionals();
    ProfessionalResponseDto updateProfessional(String cuit, ProfessionalRequestDto request);
    void deleteProfessional(String cuit);
    ProfessionalResponseDto getProfessionalByDni(String dni);
    ProfessionalResponseDto getPrefessionalByEmail(String email);
    ProfessionalResponseDto enableProfessional(Long id);
    ProfessionalResponseDto disableProfessional(Long id);
}


