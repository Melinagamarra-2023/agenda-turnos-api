package com.melina.beauty_salon_booking_backend.model;


import com.melina.beauty_salon_booking_backend.security.model.RolUsuario;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private String dni;

    private String address;

    private String phone;

    private String email;

    private String password;

    private Boolean activo;

    private String rol;

    @Enumerated(EnumType.STRING)
    private RolUsuario rolUsuario;
}

