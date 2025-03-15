package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.DTODniCiudadano;
import com.CivilRegistro.RegistroCivil.services.DTOservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private DTOservices dtoServices;

    @GetMapping("/panel")
    public String panel(@RequestParam(name = "cedula", required = false, defaultValue = "") String cedula, Model model) {
        List<DTODniCiudadano> ciudadanos = dtoServices.GetAllInformacion(cedula);
        model.addAttribute("ciudadanos", ciudadanos);
        model.addAttribute("cedula", cedula);
        return "user/user";
    }
}


