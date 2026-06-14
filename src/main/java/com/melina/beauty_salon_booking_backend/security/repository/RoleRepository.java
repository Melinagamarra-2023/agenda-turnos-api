package com.melina.beauty_salon_booking_backend.security.repository;

import com.melina.beauty_salon_booking_backend.security.model.ERole;
import com.melina.beauty_salon_booking_backend.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
