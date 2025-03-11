package com.CivilRegistro.RegistroCivil.models;


import jakarta.persistence.*;

@Entity
@Table(name = "notarios")
public class Notario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String notarioId;
    private String nombres;
    private String direccionNotaria;

}
