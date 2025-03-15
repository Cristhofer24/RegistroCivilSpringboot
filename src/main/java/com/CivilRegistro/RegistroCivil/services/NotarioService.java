package com.CivilRegistro.RegistroCivil.services;

import com.CivilRegistro.RegistroCivil.models.Notario;
import com.CivilRegistro.RegistroCivil.repository.NotarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotarioService {

    @Autowired
    private NotarioRepository notarioRepository;

    public List<Notario> obtenerTodos() {
        return notarioRepository.findAll();
    }

    public Notario obtenerPorId(Long id) {
        return notarioRepository.findById(id).orElse(null);
    }

    public void guardar(Notario notario) {
        notarioRepository.save(notario);
    }

    public void actualizar(Long id, Notario notario) {
        if (notarioRepository.existsById(id)) {
            notario.setNotarioId(id);
            notarioRepository.save(notario);
        }
    }

    public void eliminar(Long id) {
        notarioRepository.deleteById(id);
    }
}
