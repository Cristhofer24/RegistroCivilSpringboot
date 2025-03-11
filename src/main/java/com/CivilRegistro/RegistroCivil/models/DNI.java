package com.CivilRegistro.RegistroCivil.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "DNI")
public class DNI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dniId;
    private String estadoCivil;
    private String cedula;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaemision;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechavencimiento;
}
