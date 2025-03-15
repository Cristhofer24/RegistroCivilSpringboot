package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.Notario;
import com.CivilRegistro.RegistroCivil.services.NotarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notarios")
public class NotarioController {

    @Autowired
    private NotarioService notarioService;

    @GetMapping
    public String listarNotarios(Model model) {
        List<Notario> notarios = notarioService.obtenerTodos();
        model.addAttribute("notarios", notarios);
        return "notarios/lista";
    }

    @GetMapping("/{id}")
    public String obtenerNotario(@PathVariable Long id, Model model) {
        Notario notario = notarioService.obtenerPorId(id);
        model.addAttribute("notario", notario);
        return "notarios/detalle";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("notario", new Notario());
        return "notarios/formulario";
    }

    @PostMapping
    public String registrarNotario(@ModelAttribute Notario notario) {
        notarioService.guardar(notario);
        return "redirect:/notarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Notario notario = notarioService.obtenerPorId(id);
        model.addAttribute("notario", notario);
        return "notarios/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarNotario(@PathVariable Long id, @ModelAttribute Notario notario) {
        notarioService.actualizar(id, notario);
        return "redirect:/notarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarNotario(@PathVariable Long id) {
        notarioService.eliminar(id);
        return "redirect:/notarios";
    }
}

