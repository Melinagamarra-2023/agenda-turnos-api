package com.melina.beauty_salon_booking_backend.repository;


import com.melina.beauty_salon_booking_backend.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional,Long> {
    Optional<Professional> findByDni(String dni);
    Optional<Professional> findByEmail(String email);
    Optional<Professional> findByCuit(String cuit);
}
