package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.Ciudadano;
import com.CivilRegistro.RegistroCivil.services.CiudadanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ciudadanos")
public class CiudadanoController {

    @Autowired
    private CiudadanoService ciudadanoService;

    @GetMapping
    public String registrarCiudadano(Model model) {

        List<Ciudadano> ciudadanos = ciudadanoService.obtenerTodos();
        model.addAttribute("ciudadanos", ciudadanos);

        model.addAttribute("ciudadano", new Ciudadano());
        return "pages/formulario";
    }

    @PostMapping("/guardarCiudadano")
    public String guardarCiudadano(Ciudadano ciudadano, RedirectAttributes redirectAttributes) {
        ciudadanoService.guardar(ciudadano);
        Long idCiudadano = ciudadano.getCiudadanoId();
        redirectAttributes.addFlashAttribute("idCiudadano", idCiudadano);
        return "redirect:/dni";
    }


}
