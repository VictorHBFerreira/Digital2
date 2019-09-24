package br.com.fiap.restful.api;

import br.com.fiap.restful.entity.Musica;
import br.com.fiap.restful.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("musica")
public class MusicaResource {

    @Autowired //injeção de dependência
    private MusicaRepository rep;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Musica cadastrar(@RequestBody Musica musica){
        return rep.save(musica);
    }

    @GetMapping("{id}")
    public Musica buscar(@PathVariable int id){
        return rep.findById(id).get();
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id){
        rep.deleteById(id);
    }

    @PutMapping("{id}")
    public Musica alterar(@RequestBody Musica musica, @PathVariable int id){
        musica.setCodigo(id);
        return rep.save(musica);
    }

    @GetMapping
    public List<Musica> listar(){
        return rep.findAll();
    }

}
