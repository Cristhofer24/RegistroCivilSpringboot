package com.CivilRegistro.RegistroCivil.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="ciudadano")
public class Ciudadano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ciudadanoId;
    private String nombres;
    private String apellidos;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private String genero;
    private String nombrePadre;
    private String nombreMadre;

    /*Relacion entre Ciudadano y DNI*/
    @OneToMany(mappedBy = "fkCiudadano")
    private List<DNI> dni;


    public Long getCiudadanoId() {
        return ciudadanoId;
    }

    public void setCiudadanoId(Long ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public List<DNI> getDni() {
        return dni;
    }

    public void setDni(List<DNI> dni) {
        this.dni = dni;
    }
}
