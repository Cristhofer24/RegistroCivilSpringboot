package com.CivilRegistro.RegistroCivil.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "notarios")
public class Notario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String notarioId;
    private String nombres;
    private String direccionNotaria;

    @OneToMany (mappedBy = "fkNotario")
    private List<Registro> registros;

    public String getNotarioId() {
        return notarioId;
    }

    public void setNotarioId(String notarioId) {
        this.notarioId = notarioId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccionNotaria() {
        return direccionNotaria;
    }

    public void setDireccionNotaria(String direccionNotaria) {
        this.direccionNotaria = direccionNotaria;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
