package br.com.fiap.revisao.controller;

import br.com.fiap.revisao.model.Hotel;
import br.com.fiap.revisao.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelRepository rp;

    //cadastrar
    @GetMapping("/cadastrar")
    public String cadastrar(Hotel hotel){
        return "/hotel/form";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Hotel hotel, RedirectAttributes redirectAttributes){
        rp.save(hotel);
        redirectAttributes.addFlashAttribute("msg","Cadastrado!");
        return "redirect:/hotel/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("hotel", rp.findById(codigo));
        return "/hotel/editar";
    }

    //editar
    @PostMapping("/editar")
    public String editar(Hotel hotel, RedirectAttributes redirectAttributes) {
        rp.save(hotel);
        redirectAttributes.addFlashAttribute("msg", "Editado!");
        return "redirect:/hotel/listar";
    }
    //deletar
    @PostMapping("/excluir")
    public String deletar(int codigo, RedirectAttributes redirect){
        rp.deleteById(codigo);
        redirect.addFlashAttribute("msg", "Apagado!");
        return "redirect:/hotel/listar";
    }

    //listar
    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("hots", rp.findAll());
        return "hotel/lista";
    }

    //Pesquisar por Hotel
    @GetMapping("/listHoteis")
    
}




