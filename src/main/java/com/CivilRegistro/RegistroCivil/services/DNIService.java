package com.CivilRegistro.RegistroCivil.services;

import com.CivilRegistro.RegistroCivil.models.DNI;
import com.CivilRegistro.RegistroCivil.repository.DNIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DNIService {

    @Autowired
    private DNIRepository dniRepository;

    public List<DNI> obtenerTodos() {
        return dniRepository.findAll();
    }

    public DNI obtenerPorId(Long id) {
        return dniRepository.findById(id).orElse(null);
    }

    public void guardar(DNI dni) {
        dniRepository.save(dni);
    }

    public void actualizar(Long id, DNI dni) {
        if (dniRepository.existsById(id)) {
            dni.setDniId(id);
            dniRepository.save(dni);
        }
    }

    public void eliminar(Long id) {
        dniRepository.deleteById(id);
    }


    public String generateRandomCedula() {
        Random random = new Random();
        StringBuilder cedula = new StringBuilder();

        // Generar 10 dígitos aleatorios
        for (int i = 0; i < 10; i++) {
            cedula.append(random.nextInt(10)); // Añade un número aleatorio entre 0 y 9
        }

        return cedula.toString();
    }



}
