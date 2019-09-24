package br.com.fiap.revisao.repository;

import br.com.fiap.revisao.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByNomeContainsIgnoreCase(String nome);

}
