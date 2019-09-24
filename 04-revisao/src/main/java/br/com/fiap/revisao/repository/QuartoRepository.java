package br.com.fiap.revisao.repository;

import br.com.fiap.revisao.model.Hotel;
import br.com.fiap.revisao.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto,Integer> {

    List<Hotel> findByHotel_codigo(int hotel);
}
