package com.CivilRegistro.RegistroCivil.controllers;

import com.CivilRegistro.RegistroCivil.models.Users;
import com.CivilRegistro.RegistroCivil.roles.Roles;
import com.CivilRegistro.RegistroCivil.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private UserServices userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login",new Users());
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register",new Users());
        return "auth/register";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false)Long userId,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam(required = false) Roles rol) throws Exception {

        userService.saveUser(userId,username,password,rol);

        return "redirect:/login";
    }


}
