package com.CivilRegistro.RegistroCivil.repository;

import com.CivilRegistro.RegistroCivil.models.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
}
