package com.projeto.ads.controller;

import com.projeto.ads.enums.Curso;
import com.projeto.ads.enums.Status;
import com.projeto.ads.model.Aluno;
import com.projeto.ads.repositories.AlunoRepository;
import com.projeto.ads.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/aluno/cadastrar")
    public ModelAndView form_cadastro() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("aluno", new Aluno());
        mv.addObject("cursos", Curso.values());
        mv.addObject("statusList", Status.values());
        mv.setViewName("Aluno/inserirAluno");
        return mv;
    }

    @PostMapping("/aluno/cadastrar")
    public ModelAndView cadastrar(@ModelAttribute Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        String saida = alunoService.cadastrarAluno(aluno);

        if (saida != null && saida.equals("Cadastrado com sucesso!")) {
            mv.setViewName("redirect:/aluno/listar");
        } else {
            mv.addObject("mensagem", saida);
            mv.addObject("aluno", aluno);
            mv.addObject("cursos", Curso.values());
            mv.addObject("statusList", Status.values());
            mv.setViewName("Aluno/inserirAluno");
        }
        return mv;
    }

    @GetMapping("/aluno/listar")
    public ModelAndView listar_alunos() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("alunos", alunoRepository.findAllOrderedById());
        mv.setViewName("listaAlunos");
        return mv;
    }

    @GetMapping({"/aluno/editar/{id}", "/aluno/alterar/{id}"})
    public ModelAndView form_editar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar aluno com ID: " + id));
        mv.addObject("aluno", aluno);
        mv.addObject("cursos", Curso.values());
        mv.addObject("statusList", Status.values());
        mv.setViewName("Aluno/alterarAluno");
        return mv;
    }

    @PostMapping("/aluno/alterar")
    public ModelAndView alterar(@ModelAttribute Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        try {
            String out = alunoService.atualizarAluno(aluno);

            if (out != null) {
                mv.addObject("mensagem", out);
                mv.addObject("aluno", aluno);
                mv.addObject("cursos", Curso.values());
                mv.addObject("statusList", Status.values());
                mv.setViewName("Aluno/alterarAluno");
            } else {
                mv.setViewName("redirect:/aluno/listar");
            }
        } catch (Exception e) {
            mv.addObject("mensagem", "Erro ao tentar atualizar o aluno");
            mv.addObject("aluno", aluno);
            mv.addObject("cursos", Curso.values());
            mv.addObject("statusList", Status.values());
            mv.setViewName("Aluno/alterarAluno");
        }
        return mv;
    }

    @GetMapping("/aluno/deletar/{id}")
    public String delete(@PathVariable("id") Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/aluno/listar";
    }
}

