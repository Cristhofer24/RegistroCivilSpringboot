package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.DNI;
import com.CivilRegistro.RegistroCivil.services.DNIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dni")
public class DNIController {

    @Autowired
    private DNIService dniService;

    @GetMapping
    public String registroDNI(Model model) {
        model.addAttribute("dni", new DNI());
        return "pages/DNI";
    }
    @PostMapping("/registrar")
    public String registrarDNI( DNI dni) {
        dniService.guardar(dni);
        return "redirect:/admin/dashboard";
    }


}
