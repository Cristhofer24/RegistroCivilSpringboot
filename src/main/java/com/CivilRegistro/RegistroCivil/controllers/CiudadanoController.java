package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.Ciudadano;
import com.CivilRegistro.RegistroCivil.services.CiudadanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ciudadanos")
public class CiudadanoController {

    @Autowired
    private CiudadanoService ciudadanoService;

    @GetMapping
    public String listarCiudadanos(Model model) {
        List<Ciudadano> ciudadanos = ciudadanoService.obtenerTodos();
        model.addAttribute("ciudadanos", ciudadanos);
        return "ciudadanos/lista"; // Aquí debes tener una vista llamada "lista.html" en templates
    }

    @GetMapping("/{id}")
    public String obtenerCiudadano(@PathVariable Long id, Model model) {
        Ciudadano ciudadano = ciudadanoService.obtenerPorId(id);
        model.addAttribute("ciudadano", ciudadano);
        return "ciudadanos/detalle"; // Vista "detalle.html"
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("ciudadano", new Ciudadano());
        return "ciudadanos/formulario"; // Vista "formulario.html"
    }

    @PostMapping
    public String registrarCiudadano(@ModelAttribute Ciudadano ciudadano) {
        ciudadanoService.guardar(ciudadano);
        return "redirect:/ciudadanos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Ciudadano ciudadano = ciudadanoService.obtenerPorId(id);
        model.addAttribute("ciudadano", ciudadano);
        return "ciudadanos/formulario"; // Reutiliza la vista "formulario.html"
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCiudadano(@PathVariable Long id, @ModelAttribute Ciudadano ciudadano) {
        ciudadanoService.actualizar(id, ciudadano);
        return "redirect:/ciudadanos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCiudadano(@PathVariable Long id) {
        ciudadanoService.eliminar(id);
        return "redirect:/ciudadanos";
    }
}
