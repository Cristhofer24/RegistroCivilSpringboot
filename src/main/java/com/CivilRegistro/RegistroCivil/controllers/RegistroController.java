package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.Registro;
import com.CivilRegistro.RegistroCivil.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registros")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping
    public String listarRegistros(Model model) {
        List<Registro> registros = registroService.obtenerTodos();
        model.addAttribute("registros", registros);
        return "registros/lista";
    }

    @GetMapping("/{id}")
    public String obtenerRegistro(@PathVariable Long id, Model model) {
        Registro registro = registroService.obtenerPorId(id);
        model.addAttribute("registro", registro);
        return "registros/detalle";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("registro", new Registro());
        return "registros/formulario";
    }

    @PostMapping
    public String registrarRegistro(@ModelAttribute Registro registro) {
        registroService.guardar(registro);
        return "redirect:/registros";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Registro registro = registroService.obtenerPorId(id);
        model.addAttribute("registro", registro);
        return "registros/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarRegistro(@PathVariable Long id, @ModelAttribute Registro registro) {
        registroService.actualizar(id, registro);
        return "redirect:/registros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRegistro(@PathVariable Long id) {
        registroService.eliminar(id);
        return "redirect:/registros";
    }
}
