package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.Ciudadano;
import com.CivilRegistro.RegistroCivil.models.DNI;
import com.CivilRegistro.RegistroCivil.services.CiudadanoService;
import com.CivilRegistro.RegistroCivil.services.DNIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CiudadanoService ciudadanoService;
    @Autowired
    private DNIService dniService;

    @GetMapping("/dashboard")
    public String admin(Model model) {
        List<Ciudadano> ciudadanos = ciudadanoService.obtenerTodos();
        model.addAttribute("ciudadanos", ciudadanos);

        List<DNI> dnis = dniService.obtenerTodos();
        model.addAttribute("dnis", dnis);
        return "admin/admin";
    }



}
