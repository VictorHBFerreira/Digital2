package br.com.fiap.restful.repository;

import br.com.fiap.restful.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica,Integer> {

}
