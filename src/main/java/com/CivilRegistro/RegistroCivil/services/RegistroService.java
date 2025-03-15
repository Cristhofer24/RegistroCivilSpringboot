package com.CivilRegistro.RegistroCivil.services;

import com.CivilRegistro.RegistroCivil.models.Registro;
import com.CivilRegistro.RegistroCivil.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public List<Registro> obtenerTodos() {
        return registroRepository.findAll();
    }

    public Registro obtenerPorId(Long id) {
        return registroRepository.findById(id).orElse(null);
    }

    public void guardar(Registro registro) {
        registroRepository.save(registro);
    }

    public void actualizar(Long id, Registro registro) {
        if (registroRepository.existsById(id)) {
            registro.setRegistroId(id);
            registroRepository.save(registro);
        }
    }

    public void eliminar(Long id) {
        registroRepository.deleteById(id);
    }
}
