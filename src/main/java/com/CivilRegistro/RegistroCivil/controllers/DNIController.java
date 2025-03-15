package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.Ciudadano;
import com.CivilRegistro.RegistroCivil.models.DNI;
import com.CivilRegistro.RegistroCivil.services.CiudadanoService;
import com.CivilRegistro.RegistroCivil.services.DNIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/dni")
public class DNIController {

    @Autowired
    private DNIService dniService;

    @Autowired
    private CiudadanoService ciudadanoService;

    @GetMapping
    public String registroDNI(@ModelAttribute("idCiudadano") Long idCiudadano, Model model) {
        if (idCiudadano != null) {
            // Busca el ciudadano usando el ID
            Ciudadano ciudadano = ciudadanoService.obtenerPorId(idCiudadano);

            // Crea un objeto DNI
            DNI dni = new DNI();

            // Generar cédula aleatoria de 10 dígitos
            String cedula = dniService.generateRandomCedula();
            dni.setCedula(cedula);

            // Establecer la fecha de emisión a la fecha actual
            LocalDate fechaEmision = LocalDate.now();
            dni.setFechaemision(fechaEmision);

            // Establecer la fecha de vencimiento a 10 años en el futuro
            LocalDate fechaVencimiento = fechaEmision.plusYears(10);
            dni.setFechavencimiento(fechaVencimiento);

            // Asocia el ciudadano con el DNI
            dni.setFkCiudadano(ciudadano);

            // Agrega el objeto DNI al modelo
            model.addAttribute("dni", dni);
        }
        return "pages/DNI";
    }

    @PostMapping("/registrar")
    public String registrarDNI(@ModelAttribute("dni") DNI dni) {
        dniService.guardar(dni);
        return "redirect:/admin/dashboard";
    }









}
