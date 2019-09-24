package br.com.fiap.petshop.controller;

import br.com.fiap.petshop.model.Animal;
import br.com.fiap.petshop.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    private AnimalRepository rep;

    @GetMapping("pesquisar")
    public String pesquisar(String pesquisa, Model model){
        model.addAttribute("pets", rep.findByRacaContainsIgnoreCase(pesquisa));
        return "animal/lista";
    }

    @PostMapping("excluir")
    public String apagar(int codigo, RedirectAttributes redirect){
        rep.deleteById(codigo);
        redirect.addFlashAttribute("msg","Apagado!");
        return "redirect:/animal/listar";
    }

    @PostMapping("editar")
    public String atualizar(Animal animal, RedirectAttributes redirect){
        rep.save(animal);
        redirect.addFlashAttribute("msg","Atualizado!");
        return "redirect:/animal/listar"; //URL
    }

    @GetMapping("editar/{id}")
    public String atualizar(@PathVariable("id") int id, Model model){
        //Pesquisar o animal no banco
        Animal animal = rep.findById(id).get();
        model.addAttribute("animal",animal);
        return "animal/editar";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("pets", rep.findAll());
        return "animal/lista";
    }

    //URL - animal/cadastrar
    @GetMapping("cadastrar")
    public String cadastrar(Animal animal){
        return "animal/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Animal animal, RedirectAttributes redirect){
        rep.save(animal);
        redirect.addFlashAttribute("msg","Cadastrado!");
        return "redirect:/animal/listar";
    }

}
