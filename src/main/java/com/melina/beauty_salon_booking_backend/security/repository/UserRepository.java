package com.melina.beauty_salon_booking_backend.security.repository;

import com.melina.beauty_salon_booking_backend.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByCuit(String cuit);
    boolean existsByEmail(String email);
}
