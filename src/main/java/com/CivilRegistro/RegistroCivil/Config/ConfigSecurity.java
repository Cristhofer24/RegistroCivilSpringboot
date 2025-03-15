package com.CivilRegistro.RegistroCivil.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,SuceesLogin sucesesLogin) throws Exception {
      http.authorizeHttpRequests(auth -> auth
              .requestMatchers("/login","/register","/registro").permitAll()
              .anyRequest().authenticated()
      ).formLogin(form -> form
              .loginPage("/login")
              .successHandler(sucesesLogin)
              .permitAll()
      ).logout(logout -> logout
              .logoutUrl("/logout")
              .logoutSuccessUrl("/login"));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}



