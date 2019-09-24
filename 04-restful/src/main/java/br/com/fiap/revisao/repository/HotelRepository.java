package br.com.fiap.revisao.repository;

import br.com.fiap.revisao.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {



}