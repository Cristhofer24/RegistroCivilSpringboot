package com.CivilRegistro.RegistroCivil.models;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table( name = "registro" )
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registroId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    /*Relacion de varios a varios DNI notario*/
@ManyToOne
    @JoinColumn(name = "fkDni")
    private DNI fkDni;
@ManyToOne
    @JoinColumn(name = "fkNotario")
    private Notario fkNotario;


    public Long getRegistroId() {
        return registroId;
    }

    public void setRegistroId(Long registroId) {
        this.registroId = registroId;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public DNI getFkDni() {
        return fkDni;
    }

    public void setFkDni(DNI fkDni) {
        this.fkDni = fkDni;
    }

    public Notario getFkNotario() {
        return fkNotario;
    }

    public void setFkNotario(Notario fkNotario) {
        this.fkNotario = fkNotario;
    }
}

