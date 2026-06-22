package com.melina.beauty_salon_booking_backend.security.service;

import com.melina.beauty_salon_booking_backend.dto.ClientRequestDto;
import com.melina.beauty_salon_booking_backend.security.dto.AuthResponse;
import com.melina.beauty_salon_booking_backend.security.dto.LoginRequest;
import com.melina.beauty_salon_booking_backend.security.dto.RegisterRequest;
import com.melina.beauty_salon_booking_backend.security.model.ERole;
import com.melina.beauty_salon_booking_backend.security.model.Role;
import com.melina.beauty_salon_booking_backend.security.model.User;
import com.melina.beauty_salon_booking_backend.security.repository.RoleRepository;
import com.melina.beauty_salon_booking_backend.security.repository.UserRepository;
import com.melina.beauty_salon_booking_backend.service.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final ClientService clientService;

    @Transactional
    public void register(RegisterRequest request) {
        if (userRepository.existsByCuit(request.getCuit())) {
            throw new IllegalArgumentException("There is already a registered user with that CUIT.");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("The email is already associated with an account.");
        }

        Set<String> requestedRoleNames = request.getRoles();
        if (requestedRoleNames == null || requestedRoleNames.isEmpty()) {
            throw new IllegalArgumentException("User roles must be specified.");
        }

        Set<Role> roles = requestedRoleNames.stream()
                .map(roleName -> {
                    ERole erole;
                    try {
                        erole = ERole.valueOf(roleName.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Invalid role specified: " + roleName);
                    }
                    return roleRepository.findByName(erole)
                            .orElseThrow(() -> new IllegalArgumentException("Role not found in database: " + roleName));
                })
                .collect(Collectors.toSet());

        User user = User.builder()
                .cuit(request.getCuit())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);

        // Crear perfil de cliente al registrarse con rol CLIENT
        for (Role role : user.getRoles()) {
            if (role.getName() == ERole.CLIENT) {
                ClientRequestDto clientDto = new ClientRequestDto();
                clientDto.setName(request.getName());
                clientDto.setLastname(request.getLastname());
                clientDto.setDni(request.getDni());
                clientDto.setPhone(request.getPhone());
                clientDto.setAddress(request.getAddress());
                clientDto.setEmail(request.getEmail());
                clientDto.setCuit(request.getCuit());
                clientDto.setActivo(true);
                clientService.createClient(clientDto);
            }
        }
    }

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
