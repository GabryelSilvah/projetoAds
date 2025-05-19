package com.projeto.ads.controller;

import com.projeto.ads.model.UsuarioModel;
import com.projeto.ads.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @GetMapping("/cadastrar")
    public String form_cadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String salvar(UsuarioModel usuario) {
        return "cadastro";
    }

}
