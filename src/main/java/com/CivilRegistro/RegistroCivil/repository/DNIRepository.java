package com.CivilRegistro.RegistroCivil.repository;

import com.CivilRegistro.RegistroCivil.models.DNI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DNIRepository extends JpaRepository<DNI, Long> {
}
