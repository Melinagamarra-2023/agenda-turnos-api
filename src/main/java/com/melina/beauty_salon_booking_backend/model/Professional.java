package com.melina.beauty_salon_booking_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "professionals")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private String dni;

    private String address;

    private String phone;


    private Boolean activo;

    private String especialidad;

    @ManyToMany
    @JoinTable(
            name = "professional_services",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;

}