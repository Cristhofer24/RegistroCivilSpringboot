package com.CivilRegistro.RegistroCivil.services;

import com.CivilRegistro.RegistroCivil.models.DTODniCiudadano;
import com.CivilRegistro.RegistroCivil.repository.DNIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class DTOservices {
    @Autowired
    private DNIRepository dniRepository;


    public List<DTODniCiudadano> GetAllInformacionCiudadano() {
        // Obtienes todos los registros desde el repositorio
        List<Object[]> datos = dniRepository.getall();

        // Lista para almacenar los ciudadanos procesados
        List<DTODniCiudadano> ciudadanos = new ArrayList<>();

        // Si la lista de datos no está vacía, procesamos cada registro
        for (Object[] registro : datos) {
            // Extraemos la información y la agregamos a la lista
            ciudadanos.add(extraerInformacion(registro));
        }

        return ciudadanos;  // Retornamos la lista de ciudadanos
    }



    public List<DTODniCiudadano> GetAllInformacion(String cedula) {
        // Obtienes todos los registros desde el repositorio
        List<Object[]> datos = dniRepository.getDniByCedula(cedula);

        if(cedula==null || cedula.isEmpty()){
           datos = dniRepository.getall();
        }

        // Lista para almacenar los ciudadanos procesados
        List<DTODniCiudadano> ciudadanos = new ArrayList<>();

        // Si la lista de datos no está vacía, procesamos cada registro
        for (Object[] registro : datos) {
            // Extraemos la información y la agregamos a la lista
            ciudadanos.add(extraerInformacion(registro));
        }

        return ciudadanos;  // Retornamos la lista de ciudadanos
    }


    private DTODniCiudadano extraerInformacion(Object[] registros) {
        DTODniCiudadano informacion = new DTODniCiudadano();

        // Verificamos que hay suficientes elementos en el arreglo
        if (registros != null && registros.length > 0) {
            // Aseguramos que estamos manejando bien los tipos
            if (registros[0] instanceof String) {
                informacion.setCedula((String) registros[0]);
            }

            if (registros[1] instanceof String) {
                informacion.setNombres((String) registros[1]);
            }

            if (registros[2] instanceof String) {
                informacion.setApellidos((String) registros[2]);
            }


            // Otras propiedades de la entidad
            if (registros[3] instanceof String) {
                informacion.setGenero((String) registros[3]);
            }

            // Verificamos si es una fecha válida antes de hacer el cast
            if (registros.length > 4 && registros[4] instanceof java.sql.Date) {
                java.sql.Date fechaNacimiento = (java.sql.Date) registros[4];
                informacion.setFechaNacimiento(fechaNacimiento.toLocalDate());  // Convertimos a LocalDate
            }


            if (registros[5] instanceof String) {
                informacion.setNombrePadre((String) registros[5]);
            }

            if (registros[6] instanceof String) {
                informacion.setNombreMadre((String) registros[6]);
            }

            if (registros[7] instanceof String) {
                informacion.setEstadoCivil((String) registros[7]);
            }

            // Fechas de emisión y vencimiento
            if (registros.length > 8 && registros[8] instanceof java.sql.Date) {
                java.sql.Date fechaEmision = (java.sql.Date) registros[8];
                informacion.setFechaemision(fechaEmision.toLocalDate());  // Convertimos a LocalDate
            }

            if (registros.length > 9 && registros[9] instanceof java.sql.Date) {
                java.sql.Date fechaVencimiento = (java.sql.Date) registros[9];
                informacion.setFechavencimiento(fechaVencimiento.toLocalDate());  // Convertimos a LocalDate
            }
        }

        return informacion;

    }
}
