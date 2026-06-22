package com.melina.beauty_salon_booking_backend.service.impl;

import com.melina.beauty_salon_booking_backend.dto.ProfessionalRequestDto;
import com.melina.beauty_salon_booking_backend.dto.ProfessionalResponseDto;
import com.melina.beauty_salon_booking_backend.mapper.ProfessionalMapper;
import com.melina.beauty_salon_booking_backend.model.Professional;
import com.melina.beauty_salon_booking_backend.repository.ProfessionalRepository;
import com.melina.beauty_salon_booking_backend.service.ProfessionalService;

import java.util.List;

public class ProfesionalServiceImpl implements ProfessionalService {

    private final ProfessionalRepository repository;
    private final ProfessionalMapper professionalMapper;


    public ProfesionalServiceImpl(ProfessionalRepository repository, ProfessionalMapper professionalMapper) {
        this.repository = repository;
        this.professionalMapper = professionalMapper;
    }

    @Override
    public ProfessionalResponseDto createProfessional(ProfessionalRequestDto request) {
      Professional professional= professionalMapper.toEntity(request);
      Professional professionalSaved = repository.save(professional);
      return professionalMapper.toDto(professionalSaved);
    }

    @Override
    public ProfessionalResponseDto getPrefessionalByCuit(String cuit) {
        return repository.findByCuit(cuit)
                .map(professionalMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<ProfessionalResponseDto> getAllProfessionals() {
        return repository.findAll().stream()
                .map(professionalMapper::toDto)
                .toList();
    }


    @Override
    public ProfessionalResponseDto updateProfessional(String cuit, ProfessionalRequestDto request) {
       Professional professionalUpdate = repository.findByCuit(cuit)
               .orElseThrow(() -> new RuntimeException("Professional not found with cuit: " + cuit));

        professionalUpdate.setName(request.getName());
        professionalUpdate.setLastname(request.getLastname());
        professionalUpdate.setDni(request.getDni());
        professionalUpdate.setAddress(request.getAddress());
        professionalUpdate.setPhone(request.getPhone());
        professionalUpdate.setEmail(request.getEmail());
        professionalUpdate.setCuit(request.getCuit());
        professionalUpdate.setActivo(request.getActivo() == null ? Boolean.TRUE : request.getActivo());

        Professional updatedProfessional = repository.save(professionalUpdate);
        return professionalMapper.toDto(updatedProfessional);
    }

    @Override
    public void deleteProfessional(String cuit) {
        Professional professional= repository.findByCuit(cuit)
                .orElseThrow(() -> new RuntimeException("Professional not found with cuit: " + cuit));
        repository.delete(professional);
    }

    @Override
    public ProfessionalResponseDto getProfessionalByDni(String dni) {
        Professional professional = repository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Professional not found with dni: " + dni));
        return professionalMapper.toDto(professional);
    }

    @Override
    public ProfessionalResponseDto getPrefessionalByEmail(String email) {
        Professional professional = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Professional not found with email: " + email));
        return professionalMapper.toDto(professional);

    }

    @Override
    public ProfessionalResponseDto enableProfessional(Long id) {
        Professional professional = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professional not found with id: " + id));
        professional.setActivo(true);
        Professional updatedProfessional = repository.save(professional);
        return professionalMapper.toDto(updatedProfessional);

    }

    @Override
    public ProfessionalResponseDto disableProfessional(Long id) {
        Professional professional = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professional not found with id: " + id));
        professional.setActivo(false);
        Professional updatedProfessional = repository.save(professional);
        return professionalMapper.toDto(updatedProfessional);

    }
}
