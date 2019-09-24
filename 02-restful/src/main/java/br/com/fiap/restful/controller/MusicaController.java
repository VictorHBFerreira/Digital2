package br.com.fiap.restful.controller;

import br.com.fiap.restful.entity.Musica;
import br.com.fiap.restful.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("musica")
public class MusicaController {

    @Autowired
    private MusicaRepository rep;

    @GetMapping("cadastrar")
    public String abrirPagina(){
        return "musica/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Musica musica, Model model){
        rep.save(musica);
        model.addAttribute("msg","Cadastrado!");
        return "musica/form";
    }

}
