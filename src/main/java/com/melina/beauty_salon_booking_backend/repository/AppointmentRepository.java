package com.melina.beauty_salon_booking_backend.repository;

import com.melina.beauty_salon_booking_backend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
