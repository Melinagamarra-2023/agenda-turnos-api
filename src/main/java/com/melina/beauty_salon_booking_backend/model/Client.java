package com.melina.beauty_salon_booking_backend.model;

import com.melina.beauty_salon_booking_backend.security.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private String dni;

    private String address;

    private String phone;

    private String email;

    private Boolean activo;

    private String cuit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
