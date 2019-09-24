package com.fiap.spring.controller;

import com.fiap.spring.model.Jogo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jogo")
public class JogoController {

    //http://localhost:8080/jogo/cadastro/
    @GetMapping("cadastro")
    public String abrirForm() {
        return "jogo/cadastro";
    }

    @PostMapping("cadastro")
    public String processarForm(Jogo jogo, Model model) {
        model.addAttribute("j", jogo);
        System.out.println(jogo.getNome() + " " + jogo.getPreco() + " " + jogo.getDescricao());
        return "jogo/sucesso";
    }

}
