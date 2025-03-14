package com.CivilRegistro.RegistroCivil.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
public class DNI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dniId;

    private String estadoCivil;
    private String cedula;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaemision;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechavencimiento;

     /*Recacion de uno a varios con el ciudadano*/

    @ManyToOne
    @JoinColumn(name= "FK_ciudadano")
    private Ciudadano fkCiudadano;

    public Long getDniId() {
        return dniId;
    }

    public void setDniId(Long dniId) {
        this.dniId = dniId;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(LocalDate fechaemision) {
        this.fechaemision = fechaemision;
    }

    public LocalDate getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(LocalDate fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Ciudadano getFkCiudadano() {
        return fkCiudadano;
    }

    public void setFkCiudadano(Ciudadano fkCiudadano) {
        this.fkCiudadano = fkCiudadano;
    }
}
