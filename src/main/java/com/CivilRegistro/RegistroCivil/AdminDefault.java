package com.CivilRegistro.RegistroCivil;

import com.CivilRegistro.RegistroCivil.models.Users;
import com.CivilRegistro.RegistroCivil.repository.UserRepository;
import com.CivilRegistro.RegistroCivil.roles.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminDefault implements CommandLineRunner {
    @Autowired
    private UserRepository usuariosRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Iniciando el DataLoader...");

        // Verificar si ya existe un usuario administrador
        if (usuariosRepository.count() == 0) {
            // Si no existe, crear el usuario administrador
            Users admin = new Users();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRol(Roles.ADMIN);
            usuariosRepository.save(admin);

            // Imprimir un mensaje indicando que se creó el usuario
            System.out.println("Usuario administrador creado con éxito su username es: " + admin.getUsername() + " y su password es: admin123.");
        } else {
            System.out.println("Ya existen usuarios en la base de datos.");
        }
    }
}
