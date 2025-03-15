package com.CivilRegistro.RegistroCivil.Config;

import com.CivilRegistro.RegistroCivil.models.Users;
import com.CivilRegistro.RegistroCivil.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SuceesLogin implements AuthenticationSuccessHandler {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,Authentication authentication) throws IOException, ServletException {

        String username = authentication.getName();
        Users user = userRepository.findByUsername(username);

        if(user != null){
            String rol = user.getRol().toString();

            if("ADMIN".equals(rol)){
                response.sendRedirect("/admin/dashboard");
            }else if("USER".equals(rol)){
                response.sendRedirect("/users/panel");
            }else{
                response.sendRedirect("/login?error=true");
            }

        }else {
            response.sendRedirect("/login?error=true");
        }


    }
}
