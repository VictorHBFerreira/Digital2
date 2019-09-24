package br.com.fiap.revisao.controller;

import br.com.fiap.revisao.model.Quarto;
import br.com.fiap.revisao.repository.HotelRepository;
import br.com.fiap.revisao.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("quarto")
public class QuartoController {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Quarto quarto, Model model){
        model.addAttribute("hoteis", hotelRepository.findAll());
        return "quarto/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Quarto quarto, RedirectAttributes redirect){
        quartoRepository.save(quarto);
        redirect.addFlashAttribute("msg","Quarto registrado!");
        return "redirect:/quarto/cadastrar";
    }

    @GetMapping("/listar")
    public String listar(Model model, Integer codigoHotel){
        if(codigoHotel == null || codigoHotel == 0){
            model.addAttribute("lista", quartoRepository.findAll());
        }else{
            model.addAttribute("lista", quartoRepository.findByHotel_codigo(codigoHotel));
        }
        model.addAttribute("hoteis", quartoRepository.findAll());
        return "quarto/lista";
    }

}
