package com.CivilRegistro.RegistroCivil.repository;

import com.CivilRegistro.RegistroCivil.models.Notario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotarioRepository extends JpaRepository<Notario, Long> {
}
