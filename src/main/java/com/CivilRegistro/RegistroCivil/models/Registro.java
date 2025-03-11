package com.CivilRegistro.RegistroCivil.models;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table( name = "registro" )
public class Registro {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long registroId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;
}

