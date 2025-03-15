package com.CivilRegistro.RegistroCivil.services;

import com.CivilRegistro.RegistroCivil.models.Users;
import com.CivilRegistro.RegistroCivil.repository.UserRepository;
import com.CivilRegistro.RegistroCivil.roles.Roles;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void saveUser(Long userId, String username, String password , Roles rol) {
        if(userRepository.existsByUsername(username)){
            throw new IllegalStateException("El usuario ya existe");
        }

        Users user;
        if(userId !=null){
            user = userRepository.findById(userId).orElse(new Users());
        }else{
            user = new Users();
        }

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        if(rol == null){
         user.setRol(Roles.USER);
        }else{
            user.setRol(rol);
        }

        userRepository.save(user);


    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if(user != null){
            return new User(user.getUsername(),user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_"+user.getRol().toString())));
        }else{
            throw new UsernameNotFoundException("El usuario no existe");
        }

    }
}
