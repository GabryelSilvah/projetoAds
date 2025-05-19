package com.projeto.ads.controller;

import com.projeto.ads.model.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @GetMapping("/telaLogin")
    public ModelAndView exibir_form() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new UsuarioModel());
        mv.setViewName("telaLogin");
        return mv;
    }

    @PostMapping("/telaLogin")
    public ModelAndView autenticar(UsuarioModel usuario) {
        ModelAndView mv = new ModelAndView("cadastro");


        return new ModelAndView();
    }

}
