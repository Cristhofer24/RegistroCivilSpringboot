package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.DTODniCiudadano;
import com.CivilRegistro.RegistroCivil.services.DTOservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private DTOservices dtoServices;

    @GetMapping("/panel")
    public String panel(Model model) {
        List<DTODniCiudadano> ciudadanos = dtoServices.GetAllInformacion();
        model.addAttribute("ciudadanos", ciudadanos);
        return "user/user";
    }
}
