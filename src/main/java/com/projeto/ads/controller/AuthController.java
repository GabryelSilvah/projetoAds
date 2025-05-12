package com.projeto.ads.controller;

import com.projeto.ads.model.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @GetMapping("/login")
    public ModelAndView exibir() {
        ModelAndView mv = new ModelAndView("telaLogin");
        mv.addObject("Usuario", new UsuarioModel());
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("cadastro");


        return new ModelAndView();
    }

}
