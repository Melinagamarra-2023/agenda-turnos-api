package com.melina.beauty_salon_booking_backend.repository;


import com.melina.beauty_salon_booking_backend.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional,Long> {
}
