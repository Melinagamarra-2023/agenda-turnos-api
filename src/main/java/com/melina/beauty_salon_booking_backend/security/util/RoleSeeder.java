package com.melina.beauty_salon_booking_backend.security.util;

import com.melina.beauty_salon_booking_backend.security.model.Role;
import com.melina.beauty_salon_booking_backend.security.model.ERole;
import com.melina.beauty_salon_booking_backend.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {

        for (ERole role : ERole.values()) {
            roleRepository.findByName(role)
                    .orElseGet(() ->
                            roleRepository.save(
                                    Role.builder()
                                            .name(role)
                                            .build()));
        }
    }
}