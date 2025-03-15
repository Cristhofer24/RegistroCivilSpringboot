package com.CivilRegistro.RegistroCivil.repository;

import com.CivilRegistro.RegistroCivil.models.DNI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DNIRepository extends JpaRepository<DNI, Long> {

    @Query(value = "select dn.cedula ," +
            " cd.nombres , " + //0
            "cd.apellidos," +  //1
            "cd.genero," + //2
            "cd.fecha_nacimiento," + //3
            "cd.nombre_padre,\n" +  //4
            "cd.nombre_madre," +  //5
            "dn.estado_civil," + //6
            "dn.fechaemision," + //7
            "dn.fechavencimiento" + //8
            " from\n" +
            "ciudadano cd join\n" +
            "dni dn on\n" +
            "cd.ciudadano_id = dn.fk_ciudadano where dn.cedula = :cedula limit 1" , nativeQuery = true)
    List<Object[]> getDniByCedula(@Param("cedula") String cedula);


    @Query(value = "select dn.cedula ," +
            " cd.nombres , " + //0
            "cd.apellidos," +  //1
            "cd.genero," + //2
            "cd.fecha_nacimiento," + //3
            "cd.nombre_padre,\n" +  //4
            "cd.nombre_madre," +  //5
            "dn.estado_civil," + //6
            "dn.fechaemision," + //7
            "dn.fechavencimiento" + //8
            " from\n" +
            "ciudadano cd join\n" +
            "dni dn on\n" +
            "cd.ciudadano_id = dn.fk_ciudadano" , nativeQuery = true)
    List<Object[]> getall();

}
