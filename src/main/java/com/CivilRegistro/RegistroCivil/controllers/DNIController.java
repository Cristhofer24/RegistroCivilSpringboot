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
    public String listarDNI(Model model) {
        List<DNI> dnis = dniService.obtenerTodos();
        model.addAttribute("dnis", dnis);
        return "dni/lista";
    }

    @GetMapping("/{id}")
    public String obtenerDNI(@PathVariable Long id, Model model) {
        DNI dni = dniService.obtenerPorId(id);
        model.addAttribute("dni", dni);
        return "dni/detalle";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("dni", new DNI());
        return "dni/formulario";
    }

    @PostMapping
    public String registrarDNI(@ModelAttribute DNI dni) {
        dniService.guardar(dni);
        return "redirect:/dni";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        DNI dni = dniService.obtenerPorId(id);
        model.addAttribute("dni", dni);
        return "dni/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarDNI(@PathVariable Long id, @ModelAttribute DNI dni) {
        dniService.actualizar(id, dni);
        return "redirect:/dni";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDNI(@PathVariable Long id) {
        dniService.eliminar(id);
        return "redirect:/dni";
    }
}
