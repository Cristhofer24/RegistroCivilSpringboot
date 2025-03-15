package com.CivilRegistro.RegistroCivil.services;

import com.CivilRegistro.RegistroCivil.models.Ciudadano;
import com.CivilRegistro.RegistroCivil.repository.CiudadanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadanoService {

    @Autowired
    private CiudadanoRepository ciudadanoRepository;

    public List<Ciudadano> obtenerTodos() {
        return ciudadanoRepository.findAll();
    }

    public Ciudadano obtenerPorId(Long id) {
        return ciudadanoRepository.findById(id).orElse(null);
    }

    public void guardar(Ciudadano ciudadano) {
        ciudadanoRepository.save(ciudadano);
    }

    public void actualizar(Long id, Ciudadano ciudadano) {
        if (ciudadanoRepository.existsById(id)) {
            ciudadano.setCiudadanoId(id);
            ciudadanoRepository.save(ciudadano);
        }
    }

    public void eliminar(Long id) {
        ciudadanoRepository.deleteById(id);
    }
}
